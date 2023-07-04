package com.grupo29.techchallengeriwatts.controller;

import com.grupo29.techchallengeriwatts.domain.Eletrodomestico;
import com.grupo29.techchallengeriwatts.domain.Endereco;
import com.grupo29.techchallengeriwatts.dto.EletrodomesticoDTO;
import com.grupo29.techchallengeriwatts.dto.EnderecoDTO;
import com.grupo29.techchallengeriwatts.repository.gateway.EletrodomesticoRepository;
import com.grupo29.techchallengeriwatts.repository.gateway.EnderecoRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/iwatts/api/v1/eletrodomestico")
@Slf4j
public class EletrodomesticoController {

    @Autowired
    EletrodomesticoRepository eletrodomesticoRepository;
    @Autowired
    Validator validator;

    @PostMapping("/register")
    public ResponseEntity registerEletrodomestico(@RequestBody EletrodomesticoDTO eletrodomesticoDTO) {
        Map<Path, String> violations = validar(eletrodomesticoDTO);
        if (!violations.isEmpty()) {
            return ResponseEntity.badRequest().body(violations);
        }

        Eletrodomestico eletrodomestico = eletrodomesticoRepository.createEletrodomestico(eletrodomesticoDTO.toEletrodomestico());
        return ResponseEntity.status(HttpStatus.CREATED).body(eletrodomestico.toResponseDTO());
    }

    private <T> Map<Path, String> validar(T dto) {
        Set<ConstraintViolation<T>> violations = validator.validate(dto);
        return violations.stream()
                .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));
    }



}
