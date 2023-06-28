package com.grupo29.techchallengeriwatts.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Pessoa {
    private String nome;
    private LocalDate dataDeNascimento;
    private String sexo;
    private String parentescoUser;
}
