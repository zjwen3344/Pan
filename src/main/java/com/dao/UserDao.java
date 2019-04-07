package com.dao;
import com.pojo.User;

import java.util.List;
//
//此类负责与Mybateis沟通  这里使用XML方式注入SQL语句
//此类会被Spring-dao.xml 内配置的文件扫描  程序先检查spring-dao.xml  再去寻找mapper文件夹
//内的Usermapper.xml文件   xml文件内又配置了 此接口是它的定义项.

public interface UserDao {
    int AddUser(User user);
    List<User> LoginByUser(User user);
    List<User> SeleteUserByUserID(String ID);
}
