package pl.kosiorski.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "category_id")
  private Long id;

  @NotBlank private String name;

  @NotBlank private String description;

  @ManyToOne
  @JoinColumn(name = "ad_id")
  private Ad ad;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Ad getAd() {
    return ad;
  }

  public void setAd(Ad ad) {
    this.ad = ad;
  }
}
