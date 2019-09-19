package com.example.shiro.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @version: V1.0
 * @author: xinlei
 * @className: UserController
 * @packageName: com.example.shiro.web
 * @description: 用户控制类
 * @data: 2019-09-19 15:00
 **/
@Controller
public class UserController {
    public String doLolgin(String username, String password, Model model){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
        } catch (Exception e) {
            model.addAttribute("erro","用户名或者密码输错误！");
            e.printStackTrace();
        }
        return  "redirect: /index";
    }
    @RequiresRoles("admin")
    @GetMapping("/admin")
    public String admin(){
        return  "admin";
    }
    @RequiresRoles(value = {"admin","user"},logical = Logical.OR)
    @GetMapping("/user")
    public String user(){
        return  "user";
    }
}
