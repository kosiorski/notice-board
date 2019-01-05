package pl.kosiorski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kosiorski.model.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comments c JOIN u.users u WHERE u.id=:id")
    List<Comment> findByUserId (Long id);


    @Query("SELECT c FROM Comments c JOIN a.ads a WHERE a.id=:id")
    List<Comment> findByAdId (Long id);
}
