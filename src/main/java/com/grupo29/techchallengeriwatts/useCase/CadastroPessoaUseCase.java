package com.grupo29.techchallengeriwatts.useCase;

import com.grupo29.techchallengeriwatts.domain.Pessoa;
import com.grupo29.techchallengeriwatts.exception.UserException;
import com.grupo29.techchallengeriwatts.repository.gateway.PessoaRepository;
import com.grupo29.techchallengeriwatts.utils.FieldUtils;
import org.springframework.stereotype.Component;

@Component
public class CadastroPessoaUseCase {

  private final PessoaRepository pessoaRepository;
  private static final String USER_NOT_NULL  = "Campos de usuário obrigatórios estão nulos";

  public CadastroPessoaUseCase(PessoaRepository pessoaRepository) {
    this.pessoaRepository = pessoaRepository;
  }

  public Pessoa executeCreate(Pessoa pessoa) {
    Boolean validateFields = FieldUtils.areFieldsNotNull(
            pessoa.getNome(),
            pessoa.getEmail(),
            pessoa.getPerentesco(),
            pessoa.getSexo(),
            pessoa.getDataNascimento()
    );

    if (!validateFields) {
      throw new UserException(USER_NOT_NULL);
    }

    return pessoaRepository.createUser(pessoa);
  }
}
