package com.zyyfw;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlMimeType;

/**
 * Created by zhengweiyfw on 2018/4/9.
 * CXF上传和下载文件对象包装类 由于CXF的DataHandler无法获取文件名和文件类型，需要在上传和下载时附带文件名
 */
public class CxfFileWrapper {
    // 文件名
    private String fileName = null;
    // 文件扩展名
    private String fileExtension = null;
    // 文件二进制数据
    private DataHandler file = null;

    public final String getFileName() {
        return fileName;
    }

    public final void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public final String getFileExtension() {
        return fileExtension;
    }

    public final void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    // 注解该字段为二进制流
    @XmlMimeType("application/octet-stream")
    public final DataHandler getFile() {
        return file;
    }

    public final void setFile(DataHandler file) {
        this.file = file;
    }
}
