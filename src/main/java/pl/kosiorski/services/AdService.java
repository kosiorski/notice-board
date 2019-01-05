package pl.kosiorski.services;

import pl.kosiorski.model.Ad;
import pl.kosiorski.model.Comment;

import java.util.List;

public interface AdService {

  List<Ad> findAllByUserId(Long id);

  List<Ad> findAll();

  Ad findById(Long id);

  Ad save(Ad ad);
}
