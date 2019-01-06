package pl.kosiorski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kosiorski.model.User;
import pl.kosiorski.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/list")
  public List<User> userList() {
    return userService.findAll();
  }

  @PostMapping("/add")
  public User userAdd(@RequestBody User user) {
    return userService.save(user);
  }
}
