package com.grupo29.techchallengeriwatts.repository.entity;

import com.grupo29.techchallengeriwatts.domain.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "pessoa")
public class PessoaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String email;
  private String parents;
  private String gender;
  private LocalDateTime birthDay;
  @ManyToOne
  @JoinColumn(name = "address_id")
  private AddressEntity address;

  public Pessoa toDomain() {
    return Pessoa.builder()
            .id(this.getId())
            .nome(this.getName())
            .email(this.getEmail())
            .perentesco(this.getParents())
            .sexo(this.getGender())
            .dataNascimento(this.getBirthDay())
            .build();
  }

}
