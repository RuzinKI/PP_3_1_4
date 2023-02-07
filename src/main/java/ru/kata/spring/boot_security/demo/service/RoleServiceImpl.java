package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void add(Role role) {
        roleRepository.save(role);
        roleRepository.flush();
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role getByName(String name) {
        return roleRepository.findRoleByName(name).orElse(null);
    }



    @Override
    public Role getById(Integer id) {
        return roleRepository.getById(id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        roleRepository.findById(id)
                .map(user -> {
                    roleRepository.delete(user);
                    roleRepository.flush();
            return true;
        }).orElse(false);
    }
}
