package com.grupo29.techchallengeriwatts.repository.gateway;

import com.grupo29.techchallengeriwatts.domain.Eletrodomestico;
import com.grupo29.techchallengeriwatts.repository.entity.EletrodomesticoEntity;

public interface EletrodomesticoRepository {

  public EletrodomesticoEntity createEletrodomestico(Eletrodomestico eletrodomestico);
}
