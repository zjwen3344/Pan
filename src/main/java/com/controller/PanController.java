package com.controller;

import com.pojo.User;
import com.service.IndexPanService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @创建人
 * @创建时间:2019/4/7
 * @描述
 */
@Controller
@RequestMapping("Pan")
public class PanController {
    @Autowired
    private IndexPanService panServuce;


    @RequestMapping("/MyPan")
    public ModelAndView MyPan(HttpServletRequest request){
        ModelAndView mav=new ModelAndView("MyPan");
        User User = (User)request.getSession().getAttribute("user");
        ResponseResult resultfile=  panServuce.IndexFile(User.getID());
        ResponseResult resultdir=panServuce.IndexDir(User.getID());
        if(resultfile.getCode()=="400")
        {
            mav.addObject("errorMsg","在查询文件时发生错误");
            mav.setViewName("error");
            return  mav;
        }

        if(resultdir.getCode()=="400")
        {
            mav.addObject("errorMsg","在查询文件夹时发生错误");
            mav.setViewName("error");
            return  mav;
        }

        mav.addObject("files",resultfile);
        mav.addObject("dirs",resultdir);
        return mav;
    }




}
