package com.grupo29.techchallengeriwatts.repository.entity;

import com.grupo29.techchallengeriwatts.domain.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddressEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String rua;
  private String numero;
  private String cidade;
  private String estado;
  private String cep;
  private String pais;
  private String bairro;

  public Address toDomain() {
    return Address.builder()
            .id(this.getId())
            .rua(this.getRua())
            .numero(this.getNumero())
            .cidade(this.getCidade())
            .estado(this.getEstado())
            .cep(this.getCep())
            .pais(this.getPais())
            .bairro(this.getBairro())
            .build();
  }
}
