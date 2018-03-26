package br.faustikle.desafio.api.infrastructure.security.filter;

import br.faustikle.desafio.api.domain.exception.UsuarioNaoEncontradoException;
import br.faustikle.desafio.api.infrastructure.service.JWTService;
import br.faustikle.desafio.api.infrastructure.service.JWTUserDetailsService;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUserDetailsService userDetailsService;

    @Autowired
    private JWTService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        String email = "";

        try {
            if (token != null) {
                token = token.replace("Bearer ", "");
                email = jwtService.obterEmail(token);
            }

            if (email.isEmpty() || SecurityContextHolder.getContext().getAuthentication() != null) {
                filterChain.doFilter(request, response);
                return;
            }

            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        } catch (UsuarioNaoEncontradoException exception) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } catch (JwtException exception) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } catch (Throwable exception) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ocorreu algum erro interno.");
        }
    }
}
