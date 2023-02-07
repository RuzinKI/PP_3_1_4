package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getAll();

    User getById(Long id);

    void delete(Long id);

    void update(Long id, User user);

    public User getByName(String name);
}