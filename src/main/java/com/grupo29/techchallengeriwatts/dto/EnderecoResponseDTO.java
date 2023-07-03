package com.grupo29.techchallengeriwatts.dto;

import com.grupo29.techchallengeriwatts.domain.Endereco;
import lombok.Getter;

@Getter
public class EnderecoResponseDTO {
    private final Long id;

    public EnderecoResponseDTO(Endereco endereco) {
        this.id = endereco.getId();
    }

}
