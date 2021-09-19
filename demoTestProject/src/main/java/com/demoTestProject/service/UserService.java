package com.demoTestProject.service;

import com.demoTestProject.entity.User;

import java.util.List;

public interface UserService {

        public List<User> findAll();

        public User findById(int theId);
        public User findByEmail(String email);

        public void save(User theEmployee);

        public void deleteById(String theId);




}
