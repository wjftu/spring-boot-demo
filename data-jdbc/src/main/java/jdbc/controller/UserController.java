package jdbc.controller;

import jdbc.entity.User;
import jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("user")
    public List<User> findById(@RequestParam Long id){
        return userService.findById(id);
    }

    @RequestMapping("user/all")
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping("user/insert")
    public int insert(@RequestParam String username, @RequestParam Integer age){
        return userService.insert(username, age);
    }

    @RequestMapping("user/update")
    public int update(@RequestParam Long id, @RequestParam String username, @RequestParam Integer age){
        return userService.update(id, username, age);
    }

    @RequestMapping("user/delete")
    public int delete(@RequestParam Long id){
        return userService.delete(id);
    }
}
