package com.grupo29.techchallengeriwatts.dto;

import com.grupo29.techchallengeriwatts.domain.Eletrodomestico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class EletrodomesticoResponseDTO {
    private final Long id;

    private String nome;
    private String modelo;
    private Integer potencia;

    public EletrodomesticoResponseDTO(Eletrodomestico eletrodomestico) {
        this.id = eletrodomestico.getId();
        this.nome = eletrodomestico.getNome();
        this.modelo = eletrodomestico.getModelo();
        this.potencia = eletrodomestico.getPotencia();
    }
}
