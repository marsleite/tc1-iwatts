package com.grupo29.techchallengeriwatts.repository.gateway;

import com.grupo29.techchallengeriwatts.domain.Eletrodomestico;
import com.grupo29.techchallengeriwatts.exception.RepositoryException;
import com.grupo29.techchallengeriwatts.repository.entity.EletrodomesticoEntity;
import com.grupo29.techchallengeriwatts.repository.gateway.spring.EletrodomesticoRepositoryGatewaySpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EletrodomesticoRepositoryImpl implements EletrodomesticoRepository{

  private final EletrodomesticoRepositoryGatewaySpring eletrodomesticoRepositoryGatewaySpring;
  private static final String ERROR_MESSAGE  = "Eletrodomestico já cadastrado";

  @Autowired
  public EletrodomesticoRepositoryImpl(EletrodomesticoRepositoryGatewaySpring eletrodomesticoRepositoryGatewaySpring) {
    this.eletrodomesticoRepositoryGatewaySpring = eletrodomesticoRepositoryGatewaySpring;
  }
  @Override
  public Eletrodomestico createEletrodomestico(Eletrodomestico eletrodomestico) {
    if (eletrodomesticoRepositoryGatewaySpring.findByModelo(eletrodomestico.getModelo())) {
      throw new RepositoryException(ERROR_MESSAGE);
    }

    return eletrodomesticoRepositoryGatewaySpring.save(
            EletrodomesticoEntity.builder()
                    .nome(eletrodomestico.getNome())
                    .modelo(eletrodomestico.getModelo())
                    .potencia(eletrodomestico.getPotencia())
                    .build()
    ).toDomain();
  }
}
