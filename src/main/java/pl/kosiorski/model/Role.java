package pl.kosiorski.model;

import pl.kosiorski.model.enums.EnumRoles;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @NotBlank
    private EnumRoles role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumRoles getRole() {
        return role;
    }

    public void setRole(EnumRoles role) {
        this.role = role;
    }
}
