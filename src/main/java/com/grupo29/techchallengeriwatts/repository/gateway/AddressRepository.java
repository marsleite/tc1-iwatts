package com.grupo29.techchallengeriwatts.repository.gateway;

import com.grupo29.techchallengeriwatts.domain.Address;
import com.grupo29.techchallengeriwatts.repository.entity.AddressEntity;

public interface AddressRepository {

  AddressEntity createAddress(Address address);
}
