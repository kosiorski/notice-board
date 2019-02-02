package pl.kosiorski.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.kosiorski.dto.UserDto;
import pl.kosiorski.model.User;
import pl.kosiorski.repository.UserRepository;
import pl.kosiorski.auth.AuthService;
import pl.kosiorski.validations.LoginAttemptValidationGroup;
import pl.kosiorski.validations.RegistrationAttemptValidationGroup;

@RestController
@RequestMapping("/home")
public class HomeController {

  private final AuthService authService;
  private final UserRepository userRepository;

  public HomeController(AuthService authService, UserRepository userRepository) {
    this.authService = authService;
    this.userRepository = userRepository;
  }

  @PostMapping("/login")
  public String login(
      @Validated(LoginAttemptValidationGroup.class) @RequestBody UserDto loginAttempt,
      BindingResult bindingResult) {

    if (authService.isUserLoggedIn()) {
      return "JESTEŚ JUŻ ZALOGOWANY " + loginAttempt.getLogin();
    }

    if (bindingResult.hasErrors()) {
      return "forms/login ERROR JESZCZE RAZ";
    }

    authService.setUser(userRepository.findByLogin(loginAttempt.getLogin()));
    return "JEST AUTORYZACJA " + loginAttempt.getLogin();
  }

  @PostMapping("/register")
  public String register(
      @Validated(RegistrationAttemptValidationGroup.class) @RequestBody UserDto registrationAttempt,
      BindingResult bindingResult) {

    if (authService.isUserLoggedIn()) {
      return "JESTEŚ JUŻ ZAREJESTROWANY" + registrationAttempt.getLogin();
    }

    if (bindingResult.hasErrors()) {
      return "forms/register ERROR JESZCZE RAZ";
    }

    User newUser = userRepository.save(registrationAttempt.toUser());
    authService.setUser(newUser);
    return "ZAREJESTROWANO " + newUser.getLogin();
  }
}
