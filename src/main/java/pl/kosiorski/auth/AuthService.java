package pl.kosiorski.auth;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import pl.kosiorski.model.User;

@Service
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AuthService {

  private User user;

  public boolean isUserLoggedIn() {
    return user != null;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void logout() {
    this.user = null;
  }
}
