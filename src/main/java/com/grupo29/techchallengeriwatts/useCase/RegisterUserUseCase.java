package com.grupo29.techchallengeriwatts.useCase;

import com.grupo29.techchallengeriwatts.domain.User;
import com.grupo29.techchallengeriwatts.exception.UserException;
import com.grupo29.techchallengeriwatts.repository.gateway.UserRepository;
import com.grupo29.techchallengeriwatts.utils.FieldUtils;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserUseCase {

  private final UserRepository userRepository;
  private static final String USER_NOT_NULL  = "Campos de usuário obrigatórios estão nulos";

  public RegisterUserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User executeCreate(User user) {
    Boolean validateFields = FieldUtils.areFieldsNotNull(
            user.getName(),
            user.getEmail(),
            user.getParents(),
            user.getGender(),
            user.getBirthDay()
    );

    if (!validateFields) {
      throw new UserException(USER_NOT_NULL);
    }

    return userRepository.createUser(user);
  }
}
