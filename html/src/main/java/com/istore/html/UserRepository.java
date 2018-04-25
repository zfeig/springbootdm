package com.istore.html;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(int id);
    List<User> findByName(String name);
}
