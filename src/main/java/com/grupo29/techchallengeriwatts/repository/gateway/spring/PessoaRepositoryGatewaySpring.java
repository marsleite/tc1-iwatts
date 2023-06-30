package com.grupo29.techchallengeriwatts.repository.gateway.spring;

import com.grupo29.techchallengeriwatts.repository.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepositoryGatewaySpring extends JpaRepository<PessoaEntity, Long> {

  @Query("SELECT COUNT(p) > 0 FROM PessoaEntity p WHERE p.email = :email")
  Boolean existsByEmail(@Param("email") String email);
}
