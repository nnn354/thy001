package com.example.thyme001.controller;

import com.example.thyme001.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MyController {
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("message","bad world");
        model.addAttribute("url","<a href='https://www.bilibili.com/video/BV1NkFVzwEEj/?share_source=copy_web&vd_source=038c194abb9454b04e0551c5c1ca7fbf'>黑瞎子月光mv</a>");

        User user = new User("黑瞎子", LocalDate.of(1900, 1, 23), "123456");
        model.addAttribute("user",user);

        User user1= new User("解雨臣", LocalDate.of(1900, 1, 23), "123456");
        model.addAttribute("user1",user1);

        User user2= new User("吴邪", LocalDate.of(1900, 1, 23), "123456");
        model.addAttribute("user2",user2);

        model.addAttribute("age1",19);

        model.addAttribute("name0","黑瞎子");
      //  model.addAttribute("name2","解雨臣");
        List<User> users= Arrays.asList(user,user1,user2);
        model.addAttribute("userList",users);


        return "index";
    }
}
