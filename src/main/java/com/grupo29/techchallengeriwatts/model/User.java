package com.grupo29.techchallengeriwatts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class User {

  private Long id;
  private String name;
  private String email;
  private String password;
  private String parents;
  private String gender;
  private LocalDateTime birthDay;
}
