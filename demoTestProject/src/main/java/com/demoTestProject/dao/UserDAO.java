package com.demoTestProject.dao;

import com.demoTestProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Integer> {

    public List<User> findAll();

    public User findById(int theId);

    public User findByEmail(String email);

    public User save(User theEmployee);

    public void delete(String theId);

}
