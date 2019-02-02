package pl.kosiorski.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kosiorski.model.Role;
import pl.kosiorski.model.enums.EnumRoles;
import pl.kosiorski.repository.RoleRepository;
import pl.kosiorski.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  @Autowired
  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public Role findRoleById(Long id) {
    return roleRepository.findById(id).get();
  }

  @Override
  public Role findRoleByName(EnumRoles role) {
    return roleRepository.findRoleByRole(role);
  }

//  @Override
//  public Role findRoleByUserId(Long id) {
//    return roleRepository.findRoleByUserId(id);
//  }
}
