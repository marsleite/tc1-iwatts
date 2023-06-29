package com.grupo29.techchallengeriwatts.repository.gateway.spring;

import com.grupo29.techchallengeriwatts.repository.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositoryGatewaySpring extends JpaRepository<PessoaEntity, Long> {

  Boolean findByEmail(String email);
}
