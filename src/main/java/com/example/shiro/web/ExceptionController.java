package com.example.shiro.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.AuthenticationException;

/**
 * @version: V1.0
 * @author: xinlei
 * @className: ExceptionController
 * @packageName: com.example.shiro.web
 * @description:
 * @data: 2019-09-19 15:13
 **/
@ControllerAdvice
public class ExceptionController {
    public ModelAndView error(AuthenticationException e){
        ModelAndView mv = new ModelAndView("unauthorized");
        mv.addObject("error",e.getMessage());
        return  mv;
    }
}
