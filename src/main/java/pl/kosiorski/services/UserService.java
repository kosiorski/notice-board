package pl.kosiorski.services;

import pl.kosiorski.model.Ad;
import pl.kosiorski.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByLogin(String login);

    void save(User user);

    List<User> findByAd(Ad ad);

    List<User> findByAdId(Long id);
}
