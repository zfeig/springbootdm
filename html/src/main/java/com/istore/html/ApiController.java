package com.istore.html;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/api",method = RequestMethod.GET)
public class ApiController {
    @Autowired
    private UserService userService;


    @ApiOperation(value="创建用户", notes="根据参数创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "email", value = "用户邮箱", required = true, dataType = "String",paramType="query")
    })
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public @ResponseBody String addUser(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userService.add(user);
        return "user saved";
    }



    @ApiOperation(value="获取用户列表", notes="获取全部用户")
    @GetMapping("/users")
    public @ResponseBody List<User> getAllUsers() {
        return userService.getAll();
    }


    @ApiOperation(value="通过id获取用户详情", notes="根据id获取用户详情")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long",paramType = "path")
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public @ResponseBody User findOneById(@PathVariable(value = "id") int id) {
        System.out.println(id);
        return userService.findById(id);
    }


    @ApiOperation(value="通过name查找用户信息", notes="根据name获取用户信息")
    @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String",paramType = "path")
    @RequestMapping(value="/detail/{name}",method = RequestMethod.GET)
    public @ResponseBody List<User> findOneByName(@PathVariable(value = "name") String name) {
        System.out.println("name is:"+name);
        return userService.findByName(name);
    }

}
