package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dao.FileDao;
import com.pojo.User;
import  com.pojo.File;
import com.service.UploadService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @创建人
 * @创建时间:2019/4/7
 * @描述
 */
@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private FileDao fileDao;

    JSONObject json=new JSONObject();

    @Override
    public String Upload(MultipartFile multipartFile,String DirID,HttpServletRequest request ) {
        ResponseResult result=new ResponseResult();

        //生成要上传文件的UUID
        String fileID= UUID.randomUUID().toString().replaceAll("-","");
        //上传人的ID
        String UserID= ((User)request.getSession().getAttribute("user")).getID();
        //文件的类型
        String FileType="."+multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1);
        //文件的名称
        String fileName =multipartFile.getOriginalFilename();
        //所属文件夹ID
        String  dIRid= DirID;
        //文件下载地址
        String dowLike="/Upload/"+fileID+FileType;
        //得到文件上传目的位置的真实路径
        String Path = request.getServletContext().getRealPath("/WEB-INF/JSP/Upload/");
        //文件图标
        String FileIOC;
        switch (FileType){
            case ".zip":
                FileIOC="/static/img/ZIP.png";
                break;
            case ".rar":
                FileIOC="/static/img/ZIP.png";
                break;
            case ".xls":
                FileIOC="/static/img/Excel.png";
                break;
            case ".xlsx":
                FileIOC="/static/img/Excel.png";
                break;
            case ".exe":
                FileIOC="/static/img/EXE.png";
                break;
            case ".txt":
                FileIOC="/static/img/Text.png";
                break;
            case ".doc":
                FileIOC="/static/img/Word.png";
                break;
            case ".docx":
                FileIOC="/static/img/Word.png";
                break;
            case ".mp4":
                FileIOC="/static/img/Video.png";
                break;
            case ".avi":
                FileIOC="/static/img/Video.png";
                break;
            case ".mkv":
                FileIOC="/static/img/Video.png";
                break;
            case ".c":
                FileIOC="/static/img/Code.png";
                break;
            case ".class":
                FileIOC="/static/img/Code.png";
                break;
            case ".java":
                FileIOC="/static/img/Code.png";
                break;
            case ".jar":
                FileIOC="/static/img/Code.png";
                break;
            case ".html":
                FileIOC="/static/img/Code.png";
                break;
            case ".css":
                FileIOC="/static/img/Code.png";
                break;
            case ".js":
                FileIOC="/static/img/Code.png";
                break;
            case ".cs":
                FileIOC="/static/img/Code.png";
                break;
            default:
                FileIOC="/static/img/MiC.png";
        }


        java.io.File file=new java.io.File(Path+fileID+FileType);
        try {
            multipartFile.transferTo(file);

        }catch (Exception e){
            result.setCode("400");
            result.setMsg("上传文件发生错误请检查日志");
            return  json.toJSONString(result);
        }
        File fileadd=new File();
        fileadd.setID(fileID);
        fileadd.setUploadUserID(UserID);
        fileadd.setFileName(fileName);
        fileadd.setFile_format(FileType);
        fileadd.setFileMD5("MD5还是不写了吧");
        fileadd.setDow_link(dowLike);
        fileadd.setDirectoriesID(dIRid);
        fileadd.setFileImg(FileIOC);
        fileDao.Add(fileadd);
        System.out.println("向数据库添加文件成功");
        result.setCode("200");
        result.setMsg("上传文件成功");
        return  json.toJSONString(result);
    }
}
