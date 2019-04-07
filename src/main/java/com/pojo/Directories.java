package com.pojo;

/**
 * @创建人 zcl
 * @创建时间:2019/4/7
 * @描述 文件夹的实体
 */
public class Directories {

    private  String ID;
    private  String directoriesName;
    private  String UserID;
    private  boolean ISdelete;
    private  String Superior_directories;


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDirectoriesName() {
        return directoriesName;
    }

    public void setDirectoriesName(String directoriesName) {
        this.directoriesName = directoriesName;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public boolean isISdelete() {
        return ISdelete;
    }

    public void setISdelete(boolean ISdelete) {
        this.ISdelete = ISdelete;
    }

    public String getSuperior_directories() {
        return Superior_directories;
    }

    public void setSuperior_directories(String superior_directories) {
        Superior_directories = superior_directories;
    }


}
