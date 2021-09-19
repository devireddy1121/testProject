package com.demoTestProject.service;

import com.demoTestProject.dao.UserDAO;
import com.demoTestProject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(com.demoTestProject.dao.UserDAO userDAO) {
        this.userDAO=userDAO;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        System.out.println("in employeeServiceImpl findAll method");
        return userDAO.findAll();

    }

    @Override
    @Transactional
    public User findById(int theId) {

        return userDAO.findById(theId);
    }
    @Override
    @Transactional
    public User findByEmail(String email){
        return userDAO.findByEmail(email);
    }
    @Override
    @Transactional
    public void save(User theUser) {
        userDAO.save(theUser);
    }

    @Override
    @Transactional
    public void deleteById(String theId) {
        userDAO.delete(theId);

    }


}
