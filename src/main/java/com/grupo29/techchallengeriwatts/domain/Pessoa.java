package com.grupo29.techchallengeriwatts.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoa {

    private Long id;
    private String nome;
    private String email;
    private String parentesco;
    private String sexo;
    private LocalDate dataNascimento;
}
