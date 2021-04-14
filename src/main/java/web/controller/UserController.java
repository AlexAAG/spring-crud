package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //21
    @GetMapping("/users")
    public String getUsers(@RequestParam(required=false,value = "count") Integer count, Model model) {
        model.addAttribute("users", userService.getUsers(count));
        return "users";
    }
}