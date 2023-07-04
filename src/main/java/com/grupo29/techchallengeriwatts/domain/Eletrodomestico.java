package com.grupo29.techchallengeriwatts.domain;

import com.grupo29.techchallengeriwatts.dto.EletrodomesticoResponseDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Eletrodomestico {
    private Long id;
    private String nome;
    private String modelo;
    private Integer potencia;

    public EletrodomesticoResponseDTO toResponseDTO() {
        return new EletrodomesticoResponseDTO(this);
    }
}
