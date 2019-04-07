package com.dao;

import com.pojo.Directories;
import com.pojo.File;

import java.util.List;

/**
 * @创建人 zcl
 * @创建时间:2019/4/7
 * @描述 文件夹的Dao
 */
public interface DirectoriesDao {

    /**
     * 添加文件夹
     * @param directories 要添加的文件夹
     * @return
     */
    int Add(Directories directories);

    /**
     * 通过文件夹ID查询文件夹详细信息
     * @param ID 文件夹ID
     * @return 返回文件夹实体
     */
    Directories SelectByID(String ID);

    /**
     * 通过用户ID来查询此用户根目录下的所有文件夹
     * @param UserID  用户ID
     * @return  返回的是根目录所有文件夹的实体组
     */
    List<Directories> SelectByUserID(String UserID);

    /**
     * 通过文件夹ID来查询此文件夹内的所有子文件夹
     * @param UserID  用户ID
     * @param DirID   文件夹ID
     * @return 返回的是此文件的所有子文件夹组
     */
    List<Directories> SelectByDirID(String UserID,String DirID );
}
