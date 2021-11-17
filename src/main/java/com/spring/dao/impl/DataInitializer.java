package com.spring.dao.impl;

import com.spring.model.Role;
import com.spring.model.RoleType;
import com.spring.model.User;
import com.spring.service.RoleService;
import com.spring.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setName(RoleType.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setName(RoleType.USER);
        roleService.add(userRole);
        User admin = new User();
        admin.setEmail("admin@i.ua");
        admin.setPassword("admin123");
        admin.setRoles(Set.of(adminRole));
        userService.add(admin);
        User user = new User();
        user.setEmail("user@i.ua");
        user.setPassword("user1234");
        user.setRoles(Set.of(userRole));
        userService.add(user);
    }
}
