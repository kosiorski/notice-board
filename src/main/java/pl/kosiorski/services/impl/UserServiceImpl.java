package pl.kosiorski.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kosiorski.model.User;
import pl.kosiorski.repository.UserRepository;
import pl.kosiorski.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

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
        return userRepository.save(user);

    }

    @Override
    public User findByAdId(Long id) {
        return userRepository.findById(id).get();
    }
}
