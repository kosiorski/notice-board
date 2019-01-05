package pl.kosiorski.model;

import org.hibernate.annotations.CreationTimestamp;
import pl.kosiorski.model.enums.EnumStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "ads")
public class Ad {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ad_id")
  private Long id;

  @NotBlank private String title;

  @NotBlank private String description;

  private String urlImageAddress;

  @CreationTimestamp private LocalDateTime created;

  private EnumStatus status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUrlImageAddress() {
    return urlImageAddress;
  }

  public void setUrlImageAddress(String urlImageAddress) {
    this.urlImageAddress = urlImageAddress;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public EnumStatus getStatus() {
    return status;
  }

  public void setStatus(EnumStatus status) {
    this.status = status;
  }
}
