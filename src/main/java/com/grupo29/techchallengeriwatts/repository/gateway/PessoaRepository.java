package com.grupo29.techchallengeriwatts.repository.gateway;

import com.grupo29.techchallengeriwatts.domain.Pessoa;

public interface PessoaRepository {

  Pessoa createUser(Pessoa user);
}
