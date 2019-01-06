package pl.kosiorski.services;

import pl.kosiorski.model.User;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User findByLogin(String login);

    User save(User user);

//    User findByAdId(Long id);
}
