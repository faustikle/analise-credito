package br.faustikle.desafio.api.infrastructure.service;

import br.faustikle.desafio.api.domain.model.usuario.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration-time}")
    private Long expiracao;

    public String gerarToken(Usuario usuario) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",usuario.getId());
        claims.put("sub", usuario.getEmail());
        claims.put("nome", usuario.getNome());
        claims.put("papel", usuario.getPapel().getDescricao());

        Date date = new Date(System.currentTimeMillis() + expiracao * 1000);

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String obterEmail(String token) throws JwtException {
        Claims claims = obterClaims(token);

        return claims.getSubject();
    }

    public Date obterExpiracao(String token) throws JwtException {
        Claims claims = obterClaims(token);

        return claims.getExpiration();
    }

    private Claims obterClaims(String token) throws JwtException {
        Claims claims = null;

        claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

        return claims;
    }
}
