package pl.kosiorski.services;

import pl.kosiorski.model.Role;
import pl.kosiorski.model.enums.EnumRoles;

public interface RoleService {

  Role findRoleById(Long id);

  Role findRoleByName(EnumRoles roles);

//  Role findRoleByUserId(Long id);
}
