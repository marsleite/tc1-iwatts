package com.grupo29.techchallengeriwatts.repository.entity;

import com.grupo29.techchallengeriwatts.domain.Eletrodomestico;
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
public class EletrodomesticoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nome;
  private String modelo;
  private Integer potencia;

  public Eletrodomestico toDomain() {
    return Eletrodomestico.builder()
            .id(this.getId())
            .nome(this.getNome())
            .modelo(this.getModelo())
            .potencia(this.getPotencia())
            .build();
  }

}
