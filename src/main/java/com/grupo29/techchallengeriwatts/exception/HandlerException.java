package com.grupo29.techchallengeriwatts.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HandlerException {
  @JsonProperty("message")
  private String message;

  public HandlerException(String message) {
    this.message = message;
  }
}
