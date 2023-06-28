package com.grupo29.techchallengeriwatts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
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
