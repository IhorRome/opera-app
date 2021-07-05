package opera.service.impl;

import opera.dao.RoleDao;
import opera.exception.DataProcessingException;
import opera.model.Role;
import opera.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName).orElseThrow(
                () -> new DataProcessingException("Role " + roleName + " not found in DB"));
    }
}
