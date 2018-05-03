package com.istore.html;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/crud",method = RequestMethod.GET)
public class UserController {
    @Autowired
    private UserService userService;
    private static Logger logger = LogManager.getLogger(UserController.class);
    @GetMapping("/add")
    public @ResponseBody String addUser(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email) {
        User one = new User();
        one.setName(name);
        one.setEmail(email);
        userService.add(one);
        return "saved";
    }

    @GetMapping("/all")
    public @ResponseBody List<User> getAllUsers() {
        return userService.getAll();
    }

    @RequestMapping(value="/id/{id}",method = RequestMethod.GET)
    public @ResponseBody User findOneById(@PathVariable(value = "id") int id) {
//        System.out.println(id);
        logger.info("id is:"+id);
        User user = userService.findById(id);
        logger.info("obj:"+ user);
        logger.error("this is error log");
        logger.warn("this is warn log");
       return user;
    }

    @RequestMapping(value="/name/{name}",method = RequestMethod.GET)
    public @ResponseBody List<User> findOneByName(@PathVariable(value = "name") String name) {
        System.out.println("name is:"+name);
        return userService.findByName(name);
    }

}
