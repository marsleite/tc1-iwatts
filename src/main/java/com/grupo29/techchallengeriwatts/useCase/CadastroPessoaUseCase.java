package com.grupo29.techchallengeriwatts.useCase;

import com.grupo29.techchallengeriwatts.domain.Pessoa;
import com.grupo29.techchallengeriwatts.exception.UserException;
import com.grupo29.techchallengeriwatts.repository.gateway.PessoaRepository;
import com.grupo29.techchallengeriwatts.utils.FieldUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CadastroPessoaUseCase {

  private final PessoaRepository pessoaRepository;
  private static final String USER_NOT_NULL  = "Campos de usuário obrigatórios estão nulos";

  public CadastroPessoaUseCase(PessoaRepository pessoaRepository) {
    this.pessoaRepository = pessoaRepository;
  }

  public Pessoa executeCreate(Pessoa pessoa) {
    log.info("Chegou no use case: {}", pessoa);
    Boolean validateFields = FieldUtils.areFieldsNotNull(
            pessoa.getNome(),
            pessoa.getEmail(),
            pessoa.getParentesco(),
            pessoa.getSexo(),
            pessoa.getDataNascimento()
    );

    if (!validateFields) {
      throw new UserException(USER_NOT_NULL);
    }

    return pessoaRepository.createUser(pessoa);
  }
}
