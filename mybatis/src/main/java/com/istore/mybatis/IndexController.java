package com.istore.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class IndexController {
    @Autowired
    private  UserMapper userService;
    private Logger logger = LoggerFactory.getLogger(IndexController.class);
    @GetMapping("/user")
    public ArrayList<User> findByName(@RequestParam(value = "name") String name) {
        ArrayList<User> user = (ArrayList<User>) userService.findByName(name);
        logger.info("user info:"+user);
        logger.warn("warn:"+user);
        return user;
}
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable(value = "id")int id) {
        User user =  userService.findById(id);
        logger.info("user info:"+user);
        logger.warn("warn:"+user);
        return user;
    }
}
