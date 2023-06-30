package com.grupo29.techchallengeriwatts.dto;


import com.grupo29.techchallengeriwatts.domain.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class EnderecoDTO {
    @NotBlank(message = "Rua não pode ficar em branco")
    private String rua;
    @NotBlank(message = "Número não pode ficar em branco")
    @Pattern(regexp = "[\\d]", message = "Número deve conter apenas números")
    private String numero;
    @NotBlank(message = "Cidade não pode ficar em branco")
    private String cidade;
    @NotBlank(message = "Bairro não pode ficar em branco")
    private String bairro;
    @NotBlank(message = "Estado não pode ficar em branco")
    @Pattern(regexp = "^(\\s*(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)?)$",
            message = "Estado deve conter sigla correta")
    private String estado;
    @NotBlank(message = "CEP não pode ficar em branco")
    @Pattern(regexp = "[\\d]{8}", message = "CEP deve conter 8 caracteres numéricos")
    private String cep;
    @NotBlank(message = "País não pode ficar em branco")
    private String pais;

    public Endereco toEndereco() {
        return Endereco.builder()
                .rua(rua)
                .numero(numero)
                .cidade(cidade)
                .bairro(bairro)
                .estado(estado)
                .cep(cep)
                .pais(pais)
                .build();
    }
}
