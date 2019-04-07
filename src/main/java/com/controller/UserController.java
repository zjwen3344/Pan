package com.controller;


import com.pojo.User;
import com.service.UserService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//此包下面的类是 控制器类  控制器类一般只负责转发相应的请求给Server类  控制器一般只做简单判断转发,不易写复杂逻辑

//通过注解成为控制器
@Controller
//通过注解来控制路由
@RequestMapping("/User")
public class UserController {

    //通过注解自动注入User的Service类  其实就是注入 service/impl/UserServicelmpl类
    //里面有一个问题,如果有多个ServiceImpl类继承与UserService怎么办?
    @Autowired
    private UserService userService;


    @RequestMapping("toRegist")
    public  ModelAndView Regist(User user){
        ModelAndView mav=new ModelAndView();
        ResponseResult result =userService.AddUser(user);
        if(result.getCode()=="400"){
            mav.addObject("msg",result);
            mav.setViewName("regist");
            return mav;
        }else{
            mav.addObject("msg",result);
         //   mav.setViewName("redirect:Login");
            return mav;
        }

    }

    @RequestMapping("Regist")
    public  ModelAndView Regist(){
        ModelAndView mav =new ModelAndView();
        mav.setViewName("regist");
        return mav;
    }


    @RequestMapping("/toLogin")
    public  ModelAndView login(User user ,HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        ResponseResult result= userService.LoginByUser(user,request);
        if(user.getPassword()==null||user.getUserID()==null){
            mav.addObject("msg","用户名或密码不能为空");
            mav.setViewName("redirect:Login");
            return mav;
        }
        if(result.getCode()=="400"){
            mav.addObject("msg","用户名或密码错误");
            mav.setViewName("redirect:Login");
            return  mav;
        }else if(result.getCode()=="200"){
            mav.addObject("msg","登录成功!");
            mav.setViewName("redirect:/Pan/MyPan");
            return mav;
        }
        mav.addObject("msg","未知错误");
        mav.setViewName("redirect:error");
        return mav;
    }

    @RequestMapping("/Login")
    public String login(){
        return  "login";
    }



    //    下面是Result风格的登录与注册,Result风格的优势在于编写出的代码提供统一对外接口.利用Json与外界沟通,而不是返回视图,
//      统一的Json返回可以用于移动端安卓IOS,小程序等编程.而不需要单独去开发一套程序以供他们使用
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public  String addUser(@RequestBody String userJson)throws Exception {
        String resultString="";
        resultString=userService.AddUser(userJson);
        return resultString;

    }
    //    下面是Result风格的登录与注册,Result风格的优势在于编写出的代码提供统一对外接口.利用Json与外界沟通,而不是返回视图,
//    这样一套程序程序可以做出移动端/PC端  安卓  IOS  等
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public  String login(@RequestBody String jsonUSer,HttpServletRequest request )throws Exception{
        String resultinfo="";
        resultinfo=userService.LoginByUser(jsonUSer,request);
        return  resultinfo;
    }


}
