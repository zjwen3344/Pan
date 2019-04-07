package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//UserServicelmpl 是接口UserService 的具体实现类
//UserService 负责定义需要什么功能,此类负责调用Dao层的接口来实现具体功能

/**
 * @创建人 zcl
 * @创建时间:2019/4/7
 * @描述 用户的服务实现类
 */
//注解定义此类是一个具体服务类
@Service
public class UserServiceImpl implements UserService {


    //通过注解来自动注入UserDao的具体实现类,其实就是注入Mapper下面的xml文件
    @Autowired
    private UserDao userDao;

    private JSONObject json = new JSONObject();

    @Override
    public boolean RegexLogin (String ID){
        return false;
    }

    @Override
    public ResponseResult AddUser(User user) {
        ResponseResult result=new ResponseResult();
        if(user==null){
            result.setCode("400");
            result.setMsg("内容为空");
            return result;
        }
        if(userDao.SeleteUserByUserID(user.getUserID()).size()!=0){
            result.setCode("400");
            result.setMsg("用户名已被注册");
            return result;
        }
        if(user.getUserID().length()<=6){
            result.setCode("400");
            result.setMsg("用户名长度需大于6");
            return result;
        }
        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        //正则表达式的模式 编译正则表达式
        Pattern p = Pattern.compile(RULE_EMAIL);
        //正则表达式的匹配器
        Matcher m = p.matcher(user.getEmail());
        if(!m.matches()){
            result.setCode("400");
            result.setMsg("请检查邮箱的合法性");
            return  result;
        }
        if(user.getUserName()==""){
            result.setCode("400");
            result.setMsg("昵称不能为空");
            return result;
        }
        if(user.getPassword()==""){
            result.setCode("400");
            result.setMsg("密码不能为空");
            return result;
        }

        if(user.getSEX()==""){
            result.setCode("400");
            result.setMsg("性别不能为空");
            return result;
        }

        userDao.AddUser(user);
        result.setMsg("注册成功");
        result.setCode("200");
        return  result;
    }

    @Override
    public ResponseResult LoginByUser(User user, HttpServletRequest request) {
        ResponseResult result=new ResponseResult();
        if(user.getUserID()==null||user.getPassword()==null){
            result.setMsg("用户名或密码不能为空");
            result.setCode("400");
            return result;
        }
        List<User> users=userDao.LoginByUser(user);
        if(users.size()==0) {
            result.setMsg("用户名或密码错误");
            result.setCode("400");
            return result;
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("user", users.get(0));
        result.setCode("200");
        result.setMsg("登录成功!");
        return  result;
    }


    //Result风格的注册于登录
    //注册
    @Override
    public String AddUser(String jsonUser) {
        ResponseResult result =new ResponseResult();
        User user=json.parseObject(jsonUser,User.class);
        if(userDao.SeleteUserByUserID(user.getUserID())!=null){
            result.setCode("400");
            result.setMsg("用户名已存在");
            return  json.toJSONString(result);
        }
        user.genarateID();
        int num=userDao.AddUser(user);
        if(num>0){
            result.setCode("200");
            result.setMsg("注册成功！");
            result.setData(user);
        }else{
            result.setCode("400");
            result.setMsg("注册失败");
        }
        return   json.toJSONString(result);
    }

    @Override
    public String LoginByUser(String userjson, HttpServletRequest request ) {
        ResponseResult result = new ResponseResult();
        User user = json.parseObject(userjson, User.class);
        if ("".equals(user.getUserID()) || "".equals(user.getPassword())) {
            result.setCode("400");
            result.setMsg("用户名与密码不能为空");
            return json.toJSONString(result);
        }
        List<User> users = userDao.LoginByUser(user);
        if (users.size() == 0) {
            result.setCode("400");
            result.setMsg("用户名错误或密码错误");
            return json.toJSONString(result);
        } else {
            result.setCode("200");
            result.setMsg("登录成功,欢迎:" + users.get(0).getUserID());
            HttpSession session = request.getSession(true);
            session.setAttribute("user", users.get(0));
            return json.toJSONString(result);
        }
    }

}
