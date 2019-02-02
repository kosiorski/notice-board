package pl.kosiorski.dto;

import pl.kosiorski.model.User;
import pl.kosiorski.validations.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@ValidLoginAttempt(groups = LoginAttemptValidationGroup.class)
public class UserDto {

  @UniqueLogin(groups = RegistrationAttemptValidationGroup.class)
  @NotBlank(groups = RegistrationAttemptValidationGroup.class)
  private String login;

  @NotBlank(groups = RegistrationAttemptValidationGroup.class)
  private String password;

  @Email(groups = RegistrationAttemptValidationGroup.class)
  @UniqueEmail(groups = RegistrationAttemptValidationGroup.class)
  private String email;

  public User toUser() {
    User user = new User();

    user.setLogin(login);
    user.setPassword(password);
    user.setEmail(email);
    return user;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
