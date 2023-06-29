package com.grupo29.techchallengeriwatts.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Address {
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;
    private String bairro;
}
