package pl.kosiorski.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kosiorski.model.User;
import pl.kosiorski.repository.UserRepository;
import pl.kosiorski.services.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User findByLogin(String login) {
    return userRepository.findByLogin(login);
  }

  @Override
  public User save(User user) {

    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

//  @Override
//  public User findByAdId(Long id) {
//    return userRepository.findById(id).get();
//  }
}
