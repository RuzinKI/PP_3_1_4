package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface RoleService {

    void add(Role user);

    List<Role> getAll();

    Role getById(Integer id);

    void delete(Integer id);

    public Role getByName(String name);
}
