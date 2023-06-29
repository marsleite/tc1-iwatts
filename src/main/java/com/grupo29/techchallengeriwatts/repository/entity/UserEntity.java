package com.grupo29.techchallengeriwatts.repository.entity;

import com.grupo29.techchallengeriwatts.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String email;
  private String parents;
  private String gender;
  private LocalDateTime birthDay;

  public User toDomain() {
    return User.builder()
            .id(this.getId())
            .name(this.getName())
            .email(this.getEmail())
            .parents(this.getParents())
            .gender(this.getGender())
            .birthDay(this.getBirthDay())
            .build();
  }

}
