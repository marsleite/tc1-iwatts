package com.grupo29.techchallengeriwatts.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Eletrodomestico {
    private String nome;
    private String modelo;
    private String potencia;
}
