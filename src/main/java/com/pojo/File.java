package com.pojo;

import java.sql.Timestamp;
/**
 * @创建人 zcl
 * @创建时间:2019/4/7
 * @描述 文件的实体
 */
public class File {
    private  String ID;
    private  String UploadUserID;
    private  String FileName;
    private  String file_format;
    private  String fileMD5;
    private  String dow_link;
    private  String directoriesID;
    private  boolean ISdelete;
    private  int coutn;
    private  String FileImg;

    public Timestamp getUploadDate() {
        return UploadDate;
    }

    public void setUploadDate(Timestamp uploadDate) {
        UploadDate = uploadDate;
    }

    private Timestamp UploadDate;
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUploadUserID() {
        return UploadUserID;
    }

    public void setUploadUserID(String uploadUserID) {
        UploadUserID = uploadUserID;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getFile_format() {
        return file_format;
    }

    public void setFile_format(String file_format) {
        this.file_format = file_format;
    }

    public String getFileMD5() {
        return fileMD5;
    }

    public void setFileMD5(String fileMD5) {
        this.fileMD5 = fileMD5;
    }

    public String getDow_link() {
        return dow_link;
    }

    public void setDow_link(String dow_link) {
        this.dow_link = dow_link;
    }

    public String getDirectoriesID() {
        return directoriesID;
    }

    public void setDirectoriesID(String directoriesID) {
        this.directoriesID = directoriesID;
    }

    public boolean isISdelete() {
        return ISdelete;
    }

    public void setISdelete(boolean ISdelete) {
        this.ISdelete = ISdelete;
    }

    public int getCoutn() {
        return coutn;
    }

    public void setCoutn(int coutn) {
        this.coutn = coutn;
    }

    public String getFileImg() {
        return FileImg;
    }

    public void setFileImg(String fileImg) {
        FileImg = fileImg;
    }


}
