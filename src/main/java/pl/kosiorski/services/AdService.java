package pl.kosiorski.services;

import pl.kosiorski.model.Ad;

import java.util.List;

public interface AdService {

  List<Ad> findAllByUserId(Long id);

  List<Ad> findAll(Long id);

  Ad findById(Long id);

  Ad save(Ad Ad);
}
