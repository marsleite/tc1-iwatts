package com.grupo29.techchallengeriwatts.repository.gateway.spring;

import com.grupo29.techchallengeriwatts.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryGatewaySpring extends JpaRepository<UserEntity, Long> {

  Boolean findByEmail(String email);
}
