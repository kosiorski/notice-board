package pl.kosiorski.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kosiorski.model.Ad;
import pl.kosiorski.repository.AdRepository;
import pl.kosiorski.services.AdService;

import java.util.List;

@Service
public class AdServiceImpl implements AdService {

  private final AdRepository adRepository;

  @Autowired
  public AdServiceImpl(AdRepository adRepository) {
    this.adRepository = adRepository;
  }

  @Override
  public List<Ad> findAllByUserId(Long id) {
    return adRepository.findAllByUserId(id);
  }

  @Override
  public List<Ad> findAll() {
    return adRepository.findAll();
  }

  @Override
  public Ad findById(Long id) {
    return adRepository.findById(id).get();
  }

  @Override
  public Ad save(Ad ad) {
    return adRepository.save(ad);
  }
}
