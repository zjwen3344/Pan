package com.controller;

import com.service.UploadService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @创建人
 * @创建时间:2019/4/7
 * @描述
 */
@Controller
@RequestMapping("Upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public  String Upload(MultipartFile multipartFile, String DirID, HttpServletRequest request)throws Exception{
      return  uploadService.Upload(multipartFile,DirID,request);
    }
}
