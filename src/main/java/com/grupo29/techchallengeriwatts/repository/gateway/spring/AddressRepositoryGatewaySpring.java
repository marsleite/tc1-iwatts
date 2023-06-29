package com.grupo29.techchallengeriwatts.repository.gateway.spring;

import com.grupo29.techchallengeriwatts.repository.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepositoryGatewaySpring extends JpaRepository<AddressEntity, Long> {}
