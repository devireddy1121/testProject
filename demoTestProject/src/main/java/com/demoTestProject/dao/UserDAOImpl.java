package com.demoTestProject.dao;


import java.util.List;



import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoTestProject.entity.User;

import javax.persistence.EntityManager;
// implements UserDAO
@Service
public class UserDAOImpl{

    private EntityManager entityManager;


    @Autowired
   public UserDAOImpl(EntityManager theEntityManager) {
       entityManager=theEntityManager;
    }

    public UserDAOImpl() {

    }


    //@Override
    public List<User> findAll() {
        System.out.println("in userDAOImpl findAll");
        Session currentSession =  entityManager.unwrap(Session.class);
        Query<User> theQuery = currentSession.createQuery(" from User", User.class);
        List<User> users=theQuery.getResultList();
        System.out.println("in userDAOImpl findAll" +users.toString() );
        return users;
    }

    //@Override
    public User findById(int theId) {

        Session currentSession =  entityManager.unwrap(Session.class);

        User theUser = currentSession.get(User.class, theId);

        return theUser;
    }
    //@Override
    public User findByEmail(String theEmail) {

        Session currentSession =  entityManager.unwrap(Session.class);
        System.out.println("inside findbyEmail for User method, email is -- "+theEmail);
        Query<User> theQuery  = currentSession.createQuery("from User u where u.email = :emailId",User.class);
        theQuery.setParameter("emailId", theEmail);
        List<User> users=theQuery.getResultList();
        System.out.println("inside findbyEmail for User method users list size"+users.size());
        if(users.size()>0)
            return users.get(0);

        else
        return new User();
    }

    //@Override
    public void save(User theUser) {

        Session currentSession =  entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theUser);

    }

    //@Override
    public void delete(String theId) {

        Session currentSession =  entityManager.unwrap(Session.class);

        Query<User> theQuery = currentSession.createQuery(" delete from Employee where id= :employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();

    }

}
