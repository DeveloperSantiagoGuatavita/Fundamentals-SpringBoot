package com.fundamentalsPlatzi.fundamentals.dao;

import com.fundamentalsPlatzi.fundamentals.Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class UserDaoImplement implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void register(User user) {
        entityManager.merge(user);
    }


    @Override
    public List<User> getUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);
    }
}
