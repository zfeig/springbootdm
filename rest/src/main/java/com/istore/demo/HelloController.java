package com.istore.demo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/hello")
    public String  say() {
        System.out.println("restart");
        return "hello,world";
    }

    @GetMapping("/greeting")
    public Greeting  greeting(@RequestParam(value = "name",defaultValue = "world") String name) {
        String msg = String.format(template,name);
        System.out.println(msg);
        return new Greeting(counter.incrementAndGet(),msg);
    }

    @RequestMapping("/list")
    public ArrayList<Greeting>  getList(@RequestParam(value = "name",defaultValue = "world") String name) {
        ArrayList<Greeting> arr = new ArrayList<Greeting>();
        for(int i=0;i<=5;i++) {
            long idx = counter.incrementAndGet();
            String content = String.format(template,name+idx);
            Greeting obj = new Greeting(idx,content);
            arr.add(obj);
        }
        System.out.println(arr);
        return  arr;
    }

    @RequestMapping(value="/msg/{name}",method = RequestMethod.GET)
    public String msg(@PathVariable("name") String msg) {
        System.out.println(msg);
        return "hello,"+msg;
    }

}
