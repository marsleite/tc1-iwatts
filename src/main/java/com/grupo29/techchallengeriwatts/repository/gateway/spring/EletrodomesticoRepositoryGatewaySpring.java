package com.grupo29.techchallengeriwatts.repository.gateway.spring;

import com.grupo29.techchallengeriwatts.repository.entity.EletrodomesticoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EletrodomesticoRepositoryGatewaySpring extends JpaRepository<EletrodomesticoEntity, Long> {}
