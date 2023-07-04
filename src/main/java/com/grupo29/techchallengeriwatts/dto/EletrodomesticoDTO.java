package com.grupo29.techchallengeriwatts.dto;

import com.grupo29.techchallengeriwatts.domain.Eletrodomestico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class EletrodomesticoDTO {

    @NotBlank(message = "Campo nome deve ser informado.")
    private String nome;
    @NotBlank(message = "Campo modelo deve ser informado.")
    private String modelo;
    @NotNull(message = "Campo potência deve ser informado.")
    private Integer potencia;

    public Eletrodomestico toEletrodomestico() {
        return Eletrodomestico.builder()
                .nome(nome)
                .modelo(modelo)
                .potencia(potencia)
                .build();
    }

}
