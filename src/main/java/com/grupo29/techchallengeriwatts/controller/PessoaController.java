package com.grupo29.techchallengeriwatts.controller;

import com.grupo29.techchallengeriwatts.domain.Pessoa;
import com.grupo29.techchallengeriwatts.dto.PessoaRequestDTO;
import com.grupo29.techchallengeriwatts.exception.HandlerException;
import com.grupo29.techchallengeriwatts.useCase.CadastroPessoaUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/iwatts/api/v1/pessoa")
@Slf4j
public class PessoaController {
  private final CadastroPessoaUseCase cadastroPessoaUseCase;

  public PessoaController(CadastroPessoaUseCase cadastroPessoaUseCase) {
    this.cadastroPessoaUseCase = cadastroPessoaUseCase;
  }

  @PostMapping("/register")
  public ResponseEntity<?> registerPessoa(@Valid @RequestBody PessoaRequestDTO pessoa) {
    try {
      log.info("Iniciando processo de criação de Pessoa: {}", pessoa);
      Pessoa createdPessoa = cadastroPessoaUseCase.executeCreate(pessoa.toDomain());

      return ResponseEntity.status(HttpStatus.CREATED).body(createdPessoa);
    } catch (RuntimeException e) {

      HandlerException handlerException = new HandlerException(e.getMessage());
      return ResponseEntity.status(HttpStatus.CONFLICT).body(handlerException);
    } catch (Exception e) {

      HandlerException handlerException = new HandlerException(e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(handlerException);
    }
  }
}
