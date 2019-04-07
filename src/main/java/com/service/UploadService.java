package com.service;

import com.utils.ResponseResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @创建人
 * @创建时间:2019/4/7
 * @描述
 */
public interface UploadService {

    String Upload(MultipartFile multipartFile,String DirID,HttpServletRequest request );
}
