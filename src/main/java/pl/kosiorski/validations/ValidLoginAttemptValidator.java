package pl.kosiorski.validations;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kosiorski.dto.UserDto;
import pl.kosiorski.model.User;
import pl.kosiorski.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidLoginAttemptValidator implements ConstraintValidator<ValidLoginAttempt, UserDto> {

  @Autowired UserRepository userRepository;

  public void initialize(ValidLoginAttempt constraint) {}

  public boolean isValid(UserDto loginAttempt, ConstraintValidatorContext context) {
    User user = userRepository.findUserByLogin(loginAttempt.getLogin());
    return user != null && user.passwordMatches(loginAttempt.getPassword());
  }
}
