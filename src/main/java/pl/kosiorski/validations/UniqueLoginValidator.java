package pl.kosiorski.validations;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kosiorski.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {

  @Autowired
  UserRepository userRepository;

  @Override
  public void initialize(UniqueLogin constraintAnnotation) {}

  public boolean isValid(String login, ConstraintValidatorContext context) {
    return login == null || userRepository.findUserByLogin(login) == null;
  }
}
