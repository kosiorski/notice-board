package pl.kosiorski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kosiorski.model.Ad;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {}
