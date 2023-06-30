package com.grupo29.techchallengeriwatts.dto;

import com.grupo29.techchallengeriwatts.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class PessoaRequestDTO {

  private String nome;
  private String email;
  private String perentesco;
  private String sexo;
  private String dataNascimento;

  public Pessoa toDomain() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate dataNascimentoParsed = LocalDate.parse(this.getDataNascimento(), formatter);

    return Pessoa.builder()
            .nome(nome)
            .email(email)
            .parentesco(perentesco)
            .sexo(sexo)
            .dataNascimento(dataNascimentoParsed)
            .build();
  }
}
