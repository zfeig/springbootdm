package com.istore.html;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/html")
public class HtmlController {
    @Autowired
    private UserService userService;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public @ResponseBody String test() {
        User user = userService.findById(1);
        System.out.println(user.getName());
        return user.getName();
    }

    @GetMapping("/msg/{id}")
    public String msg(@PathVariable int id, ModelMap model) {
        System.out.println(id);
        User user = userService.findById(id);
        model.addAttribute("name",user.getName());
        model.addAttribute("user",user);
        return "html/index";
    }

    @GetMapping("/info")
    public String info(ModelMap model) {
      model.addAttribute("url",this.url);
      model.addAttribute("username",this.username);
      return "html/info";
    }
}
