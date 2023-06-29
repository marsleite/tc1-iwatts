package com.grupo29.techchallengeriwatts.repository.gateway;

import com.grupo29.techchallengeriwatts.domain.User;
import com.grupo29.techchallengeriwatts.exception.RepositoryException;
import com.grupo29.techchallengeriwatts.repository.entity.UserEntity;
import com.grupo29.techchallengeriwatts.repository.gateway.spring.UserRepositoryGatewaySpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserRepositoryImpl implements UserRepository{

  private final UserRepositoryGatewaySpring userRepositoryGatewaySpring;
  private static final String ERROR_MESSAGE = "Usuário já existe";

  @Autowired
  public UserRepositoryImpl(UserRepositoryGatewaySpring userRepositoryGatewaySpring) {
    this.userRepositoryGatewaySpring = userRepositoryGatewaySpring;
  }
  @Override
  public UserEntity createUser(User user) {
    if (userRepositoryGatewaySpring.existsById(user.getId())) {
      throw new RepositoryException(ERROR_MESSAGE);
    }

    return userRepositoryGatewaySpring.save(
            UserEntity.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .birthDay(user.getBirthDay())
                    .gender(user.getGender())
                    .parents(user.getParents())
                    .build()
    );
  }
}
