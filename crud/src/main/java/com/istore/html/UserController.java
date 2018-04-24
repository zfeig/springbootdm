package com.istore.html;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/crud")
public class UserController {
    @Autowired
    private UserService userService;

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

    @GetMapping("/{id}")
    public @ResponseBody User findOneById(@PathVariable(value = "id") int id) {
        System.out.println(id);
       return userService.findById(id);
    }

}
