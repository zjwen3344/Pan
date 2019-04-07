package com.service;

import com.utils.ResponseResult;

/**
 * @创建人
 * @创建时间:2019/4/7
 * @描述
 */
public interface IndexPanService {

    /**
     * 用于初始化MyPan内的文件夹
     * @param UserID 用户ID
     * @return
     */
    ResponseResult IndexDir(String UserID);


    /**
     * 用于初始化MyPan内的文件
     * @param UserID 用户ID
     * @return
     */
    ResponseResult IndexFile(String UserID);




    /**
     * 用于删除某个文件夹
     * @param UserId 用户ID
     * @param DirID 文件夹ID
     * @return
     */
    ResponseResult DeleteDir(String UserId,String DirID);

    /**
     * 用于删除某个文件
     * @param UserID 用户ID
     * @param FileID 文件ID
     * @return
     */
    ResponseResult DeleteFile(String UserID,String FileID);

    /**
     * 用于查询某个文件夹内的所有文件夹与子文件
     * @param UserID 用户ID
     * @param DirID 文件夹ID
     * @return
     */
    ResponseResult SelectByDir(String UserID,String DirID);

}
