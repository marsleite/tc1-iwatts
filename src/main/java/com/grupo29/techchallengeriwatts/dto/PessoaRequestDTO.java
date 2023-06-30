package com.grupo29.techchallengeriwatts.dto;

import com.grupo29.techchallengeriwatts.domain.Pessoa;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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
  @NotNull(message = "Nome não pode ser vazio")
  private String nome;
  @Email(message = "Formato de email inválido")
  private String email;
  private String parentesco;
  private String sexo;
  @NotNull(message = "Data de nascimento não pode ser vazio")
  private String dataNascimento;

  public Pessoa toDomain() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate dataNascimentoParsed = LocalDate.parse(this.getDataNascimento(), formatter);

    return Pessoa.builder()
            .nome(nome)
            .email(email)
            .parentesco(parentesco)
            .sexo(sexo)
            .dataNascimento(dataNascimentoParsed)
            .build();
  }
}
