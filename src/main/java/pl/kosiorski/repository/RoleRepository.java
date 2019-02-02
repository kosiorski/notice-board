package pl.kosiorski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kosiorski.model.Role;
import pl.kosiorski.model.enums.EnumRoles;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleById(Long id);

    Role findRoleByRole(EnumRoles enumRoles);


}
