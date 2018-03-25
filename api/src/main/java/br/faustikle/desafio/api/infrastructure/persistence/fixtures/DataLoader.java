package br.faustikle.desafio.api.infrastructure.persistence.fixtures;

import br.faustikle.desafio.api.domain.model.cliente.*;
import br.faustikle.desafio.api.domain.model.usuario.Usuario;
import br.faustikle.desafio.api.infrastructure.persistence.repository.ClienteRepository;
import br.faustikle.desafio.api.infrastructure.persistence.repository.PropostaDeCreditoRepository;
import br.faustikle.desafio.api.infrastructure.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@Profile("dev")
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PropostaDeCreditoRepository propostaDeCreditoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        inicializarUsuarios();
        inicializarClientes();
    }

    private void inicializarUsuarios() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Usuario analista = Usuario.newAnalista("Paulo Gustavo", "analista@gmail.com",
                encoder.encode("12345678"));

        Usuario captador = Usuario.newCaptador("João Cesar", "captador@gmail.com",
                encoder.encode("12345678"));

        if (!usuarioRepository.findOneByEmail("analista@gmail.com").isPresent()) {
            usuarioRepository.save(analista);
        }

        if (!usuarioRepository.findOneByEmail("captador@gmail.com").isPresent()) {
            usuarioRepository.save(captador);
        }
    }

    private void inicializarClientes() {
        if (!clienteRepository.findOneByDadoPessoalCpfNumero("16161566516").isPresent()) {
            clienteRepository.save(new Cliente(
                    new DadoPessoal(
                            "Carolina Rodrigues Oliveira",
                            Genero.FEMININO,
                            new Cpf(
                                    "16161566516"
                            ),
                            new Endereco(
                                    "Rua das perobeiras",
                                    "345",
                                    "58064530",
                                    "João Pessoa",
                                    "Paraiba"
                            ),
                            "83999584431",
                            LocalDate.of(1989, 12, 2)
                    ),
                    new DadoFinanceiro("Médica", BigDecimal.valueOf(5600))
            ));
        }

        if (!clienteRepository.findOneByDadoPessoalCpfNumero("30650349563").isPresent()) {
            clienteRepository.save(new Cliente(
                    new DadoPessoal(
                            "Erick Sousa Ferreira",
                            Genero.MASCULINO,
                            new Cpf(
                                    "30650349563"
                            ),
                            new Endereco(
                                    "Rua dos Craveiros",
                                    "489",
                                    "65020160",
                                    "São Luís",
                                    "Maranhão"
                            ),
                            "8173288297",
                            LocalDate.of(1932, 12, 11)
                    ),
                    new DadoFinanceiro("Mestre de Obras", BigDecimal.valueOf(780))
            ));
        }

        if (!clienteRepository.findOneByDadoPessoalCpfNumero("27071839620").isPresent()) {
            clienteRepository.save(new Cliente(
                    new DadoPessoal(
                            "Antônio Cavalcanti Sousa",
                            Genero.MASCULINO,
                            new Cpf(
                                    "27071839620"
                            ),
                            new Endereco(
                                    "Rua da Alto da Bela Vista",
                                    "557",
                                    "41100745",
                                    "Salvador",
                                    "Bahia"
                            ),
                            "7159138601",
                            LocalDate.of(1946, 7, 15)
                    ),
                    new DadoFinanceiro("Programador", BigDecimal.valueOf(18000))
            ));
        }
    }
}
