package com.grupo29.techchallengeriwatts.repository.gateway;

import com.grupo29.techchallengeriwatts.domain.Pessoa;
import com.grupo29.techchallengeriwatts.exception.RepositoryException;
import com.grupo29.techchallengeriwatts.repository.entity.PessoaEntity;
import com.grupo29.techchallengeriwatts.repository.gateway.spring.PessoaRepositoryGatewaySpring;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;


@Repository
@Slf4j
public class PessoaRepositoryImpl implements PessoaRepository {

  private final PessoaRepositoryGatewaySpring pessoaRepositoryGatewaySpring;
  private static final String ERROR_MESSAGE = "Pessoa já existe";

  public PessoaRepositoryImpl(PessoaRepositoryGatewaySpring pessoaRepositoryGatewaySpring) {
    this.pessoaRepositoryGatewaySpring = pessoaRepositoryGatewaySpring;
  }

  @Override
  public Pessoa createUser(Pessoa pessoa) {
    log.info("Chegou no repository para salvar no banco", pessoa);
    if (pessoaRepositoryGatewaySpring.existsByEmail(pessoa.getEmail())) {
      throw new RepositoryException(ERROR_MESSAGE);
    }
    return pessoaRepositoryGatewaySpring.save(
            PessoaEntity.builder()
                    .nome(pessoa.getNome())
                    .email(pessoa.getEmail())
                    .dataNascimento(pessoa.getDataNascimento())
                    .sexo(pessoa.getSexo())
                    .parentesco(pessoa.getParentesco())
                    .build()
    ).toDomain();
  }
}
