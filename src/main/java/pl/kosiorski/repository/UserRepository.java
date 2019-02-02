package pl.kosiorski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kosiorski.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

    User findUserByEmail(String email);

//    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.id=:id")
//    User findByAdId(Long id);

    User findUserByLogin(String login);
}
