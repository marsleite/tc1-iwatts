package com.grupo29.techchallengeriwatts.repository.gateway;

import com.grupo29.techchallengeriwatts.domain.Pessoa;
import com.grupo29.techchallengeriwatts.exception.RepositoryException;
import com.grupo29.techchallengeriwatts.repository.entity.PessoaEntity;
import com.grupo29.techchallengeriwatts.repository.gateway.spring.PessoaRepositoryGatewaySpring;
import org.springframework.stereotype.Repository;


@Repository
public class PessoaRepositoryImpl implements PessoaRepository {

  private final PessoaRepositoryGatewaySpring pessoaRepositoryGatewaySpring;
  private static final String ERROR_MESSAGE = "Pessoa já existe";

  public PessoaRepositoryImpl(PessoaRepositoryGatewaySpring pessoaRepositoryGatewaySpring) {
    this.pessoaRepositoryGatewaySpring = pessoaRepositoryGatewaySpring;
  }

  @Override
  public Pessoa createUser(Pessoa pessoa) {
    if (pessoaRepositoryGatewaySpring.findByEmail(pessoa.getEmail())) {
      throw new RepositoryException(ERROR_MESSAGE);
    }

    return pessoaRepositoryGatewaySpring.save(
            PessoaEntity.builder()
                    .name(pessoa.getNome())
                    .email(pessoa.getEmail())
                    .birthDay(pessoa.getDataNascimento())
                    .gender(pessoa.getSexo())
                    .parents(pessoa.getPerentesco())
                    .build()
    ).toDomain();
  }
}
