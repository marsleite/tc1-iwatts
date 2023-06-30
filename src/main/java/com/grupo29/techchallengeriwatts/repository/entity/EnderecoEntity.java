package com.grupo29.techchallengeriwatts.repository.entity;

import com.grupo29.techchallengeriwatts.domain.Endereco;
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
@Table(name = "endereco")
public class EnderecoEntity {

  @Id
  @Column(name = "endereco_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String rua;
  private String numero;
  private String cidade;
  private String estado;
  private String cep;
  private String pais;
  private String bairro;
  @OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL)
  private List<PessoaEntity> pessoas;
  @OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL)
  private List<EletrodomesticoEntity> eletrodomesticos;

  public Endereco toDomain() {
    return Endereco.builder()
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
