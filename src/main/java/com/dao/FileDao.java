package com.dao;

import com.pojo.File;

import java.util.List;

/**
 * @创建人 zcl
 * @创建时间:2019/4/6
 * @描述 文件的Dao层
 */
public interface FileDao {

    /**
     * 添加文件
     * @param file 要添加的文件
     * @return
     */
    int Add(File file);

    /**
     * 通过文件ID查询文件详细信息
     * @param ID 文件ID
     * @return 文件实体
     */
    File SelectByID(String ID);

    /**
     * 通过用户ID查询用户文件,用于根文件夹文件查询
     * @param UserID  用户ID作为副ID传入
     * @return 返回的是此用户根目录下的所有文件
     */
    List<File> SelectByUserID(String UserID);

    /**
     *返回此文件夹ID下的所有文件
     * @param UserID  用户ID
     * @param DirID   文件夹ID
     * @return 此ID下的文件组
     */
    List<File> SelectByDirID(String UserID,String DirID );

}
