package com.istore.html;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource UserRepository userDao;

    public void add(User user) {
      userDao.save(user);
    }

    public User findById(int id) {
        return userDao.findById(id);
    }

    public List<User> findByName(String name) {
        return userDao.findByName(name);
    }

    public List<User> getAll() {
        return (List<User>) userDao.findAll();
    }
}
