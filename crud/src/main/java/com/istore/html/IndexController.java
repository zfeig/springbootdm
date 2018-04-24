package com.istore.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping("/html")
   public String html(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name",name);
       return "greeting";
   }
}
