package opera.service;

import opera.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
