package com.fundamentalsPlatzi.fundamentals.dao;

import com.fundamentalsPlatzi.fundamentals.Model.User;

import java.util.List;

public interface UserDao {
    void register(User user);

    List<User> getUsers();

    void delete(Long id);


}
