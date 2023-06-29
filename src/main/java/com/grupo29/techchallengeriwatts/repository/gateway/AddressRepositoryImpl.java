package com.grupo29.techchallengeriwatts.repository.gateway;

import com.grupo29.techchallengeriwatts.domain.Address;
import com.grupo29.techchallengeriwatts.exception.RepositoryException;
import com.grupo29.techchallengeriwatts.repository.entity.AddressEntity;
import com.grupo29.techchallengeriwatts.repository.gateway.spring.AddressRepositoryGatewaySpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressRepositoryImpl implements AddressRepository {

  private final AddressRepositoryGatewaySpring addressRepositoryGatewaySpring;

  @Autowired
  public AddressRepositoryImpl(AddressRepositoryGatewaySpring addressRepositoryGatewaySpring) {
    this.addressRepositoryGatewaySpring = addressRepositoryGatewaySpring;
  }
  @Override
  public AddressEntity createAddress(Address address) {
   return addressRepositoryGatewaySpring.save(
           AddressEntity.builder()
                   .rua(address.getRua())
                   .numero(address.getNumero())
                   .cidade(address.getCidade())
                   .cep(address.getCep())
                   .estado(address.getEstado())
                   .pais(address.getPais())
                   .bairro(address.getBairro())
                   .build()
   );
  }
}
