package pl.kosiorski.model;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private Long id;

  @NotEmpty
  @Column(nullable = false, unique = true)
  private String login;

  @NotEmpty private String password;

  @Email @NotEmpty private String email;

  private String firstName;

  private String lastName;

  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

  @OneToMany(mappedBy = "user")
  private List<Ad> ads = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  private List<Comment> comments = new ArrayList<>();

  public boolean passwordMatches(String plainTextPassword) {
    return BCrypt.checkpw(plainTextPassword, this.password);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    // NOTE w przypadku gdy hasło jest pustym stringiem/nullem, funkcja hashpw zadziała i wygeneruje
    // nie-nullowego hasha
    // chcemy tego uniknąć:)
    this.password =
        password == null || password.isEmpty()
            ? password
            : BCrypt.hashpw(password, BCrypt.gensalt());
  }

  //  public void setPassword(String password) {
  //    this.password = password;
  //  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public List<Ad> getAds() {
    return ads;
  }

  public void setAds(List<Ad> ads) {
    this.ads = ads;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }
}
