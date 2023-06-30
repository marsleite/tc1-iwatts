package com.grupo29.techchallengeriwatts.repository.entity;

import com.grupo29.techchallengeriwatts.domain.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "address")
public class AddressEntity {

  @Id
  @Column(name = "address_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String rua;
  private String numero;
  private String cidade;
  private String estado;
  private String cep;
  private String pais;
  private String bairro;
  @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
  private List<PessoaEntity> pessoas;
  @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
  private List<EletrodomesticoEntity> eletrodomesticos;

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
