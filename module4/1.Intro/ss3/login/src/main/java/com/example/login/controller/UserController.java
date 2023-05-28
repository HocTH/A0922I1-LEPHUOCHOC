package com.example.login.controller;

import com.example.login.dao.UserDao;
import com.example.login.model.Login;
import com.example.login.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home","login",new Login());
        return modelAndView;
    }
@PostMapping("login")
    public ModelAndView inLogin(@ModelAttribute("login") Login login){
        User user = UserDao.checkLogin(login);
    ModelAndView modelAndView;
    if(user == null){
        modelAndView = new ModelAndView("error");
    } else {
        modelAndView = new ModelAndView("user");
            modelAndView.addObject("user",user);
    }
    return modelAndView;
}
}
