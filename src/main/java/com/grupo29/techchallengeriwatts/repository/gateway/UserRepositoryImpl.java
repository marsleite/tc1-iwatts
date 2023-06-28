package com.grupo29.techchallengeriwatts.repository.gateway;

import com.grupo29.techchallengeriwatts.domain.User;
import com.grupo29.techchallengeriwatts.repository.entity.UserEntity;
import com.grupo29.techchallengeriwatts.repository.gateway.spring.UserRepositoryGatewaySpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UserRepositoryImpl implements UserRepository{

  private final UserRepositoryGatewaySpring userRepositoryGatewaySpring;
  private static final String ERROR_MESSAGE = "User already created";

  @Autowired
  public UserRepositoryImpl(UserRepositoryGatewaySpring userRepositoryGatewaySpring) {
    this.userRepositoryGatewaySpring = userRepositoryGatewaySpring;
  }
  @Override
  public UserEntity createUser(User user) {
    if (userRepositoryGatewaySpring.existsById(user.getId())) {
      throw new RuntimeException(ERROR_MESSAGE);
    }

    return userRepositoryGatewaySpring.save(
            UserEntity.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .birthDay(user.getBirthDay())
                    .gender(user.getGender())
                    .parents(user.getParents())
                    .build()
    );
  }
}
