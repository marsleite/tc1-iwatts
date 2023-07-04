package com.grupo29.techchallengeriwatts.repository.entity;

import com.grupo29.techchallengeriwatts.domain.Eletrodomestico;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "eletrodomestico")
public class EletrodomesticoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nome;
  private String modelo;
  private Integer potencia;
  @ManyToOne
  @JoinColumn(name = "endereco_id")
  private EnderecoEntity endereco;

  @ManyToMany(mappedBy = "eletrodomesticos")
  private List<PessoaEntity> pessoas;

  public Eletrodomestico toDomain() {
    return Eletrodomestico.builder()
            .id(this.getId())
            .nome(this.getNome())
            .modelo(this.getModelo())
            .potencia(this.getPotencia())
            .build();
  }

}
