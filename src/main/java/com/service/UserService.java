package com.service;

import com.pojo.User;
import com.utils.ResponseResult;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    //注册
    String AddUser(String user);
    //登录
    String LoginByUser(String user, HttpServletRequest request);

    //查询用户名是否已注册
    boolean RegexLogin(String ID);

    ResponseResult AddUser(User user);
    ResponseResult LoginByUser(User user,HttpServletRequest request);
}
