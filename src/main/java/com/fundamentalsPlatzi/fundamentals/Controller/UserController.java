package com.fundamentalsPlatzi.fundamentals.Controller;

import com.fundamentalsPlatzi.fundamentals.Model.User;
import com.fundamentalsPlatzi.fundamentals.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "api/v1/users")//Metodo que trae todos los users
    public List<User> getUsers() {
        List<User> listaUsers = new ArrayList<>();
        return userDao.getUsers();

    }
    @RequestMapping(value = "api/v1/user/{id}", method = RequestMethod.GET)//Metodo que trae user en especifico
    public User getUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setName("Santi");
        user.setLastname("Guatavita");
        user.setEmail("santi@gmail.com");
        user.setPhone("123");
        user.setPassword("password");
        return user;
    }
    @RequestMapping(value = "api/v1/user", method = RequestMethod.POST)//Metodo que crea user
    public void createUser(@RequestBody User user) {
        userDao.register(user);
    }
    @RequestMapping(value = "api/v1/user/{id}", method = RequestMethod.DELETE)//Metodo que elimina user en especifico
    public void delete(@PathVariable Long id) {
        userDao.delete(id);
    }
}
