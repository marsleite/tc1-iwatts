package com.grupo29.techchallengeriwatts.repository.entity;

import com.grupo29.techchallengeriwatts.domain.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "pessoa")
public class PessoaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nome;
  private String email;
  private String parentesco;
  private String sexo;
  private LocalDate dataNascimento;
  @ManyToOne
  @JoinColumn(name = "endereco_id")
  private EnderecoEntity endereco;

  @ManyToMany
  @JoinTable(name = "pessoa_eletrodomestico",
          joinColumns = @JoinColumn(name = "pessoa_id"),
          inverseJoinColumns = @JoinColumn(name = "eletrodomestico_id"))
  private List<EletrodomesticoEntity> eletrodomesticos;

  public Pessoa toDomain() {
    return Pessoa.builder()
            .id(this.getId())
            .nome(this.getNome())
            .email(this.getEmail())
            .parentesco(this.getParentesco())
            .sexo(this.getSexo())
            .dataNascimento(this.getDataNascimento())
            .build();
  }

}
