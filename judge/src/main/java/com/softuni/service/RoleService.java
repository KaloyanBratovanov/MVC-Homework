package com.softuni.service;

import com.softuni.model.entity.Role;
import com.softuni.model.entity.RoleNameEnum;

public interface RoleService {
    void initRoles();

    Role findRole(RoleNameEnum roleNameEnum);
}
