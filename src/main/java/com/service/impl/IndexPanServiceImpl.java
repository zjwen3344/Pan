package com.service.impl;

import com.dao.DirectoriesDao;
import com.dao.FileDao;
import com.service.IndexPanService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @创建人
 * @创建时间:2019/4/7
 * @描述
 */
@Service
public class IndexPanServiceImpl implements IndexPanService {

    @Autowired
    private DirectoriesDao directoriesDao;

    @Autowired
    private FileDao fileDao;

    private  ResponseResult result;

    @Override
    public ResponseResult IndexDir(String UserID) {

        result =new ResponseResult();
        try {
            result.setCode("200");
            result.setMsg("查询成功");
            result.setData(directoriesDao.SelectByUserID(UserID));

        }catch(  Exception e ){
            result.setCode("400");
            result.setMsg("在查询文件夹时发生错误");
            return result;
        }
        return result;
    }

    @Override
    public ResponseResult IndexFile(String UserID) {
        result =new ResponseResult();
        try {
            result.setCode("200");
            result.setMsg("查询成功");
            result.setData(fileDao.SelectByUserID(UserID));

        }catch(  Exception e ){
            result.setCode("400");
            result.setMsg("在查询文件时发生错误");
            return result;
        }

        return result;
    }

    @Override
    public ResponseResult DeleteDir(String UserId, String DirID) {
        return null;
    }

    @Override
    public ResponseResult DeleteFile(String UserID, String FileID) {
        return null;
    }

    @Override
    public ResponseResult SelectByDir(String UserID, String DirID) {
        return null;
    }
}
