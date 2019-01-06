package pl.kosiorski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kosiorski.model.Ad;
import pl.kosiorski.services.AdService;

import java.util.List;

@RestController
@RequestMapping("/ad")
public class AdController {

  private final AdService adService;

  @Autowired
  public AdController(AdService adService) {
    this.adService = adService;
  }

  @GetMapping("/list")
  public List<Ad> adList() {
    return adService.findAll();
  }

  @PostMapping("/add")
  public Ad adAdd(@RequestBody Ad ad) {
    return adService.save(ad);
  }
}
