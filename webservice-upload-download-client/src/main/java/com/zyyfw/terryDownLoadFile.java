package com.zyyfw;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import java.io.*;

/**
 * Created by zhengweiyfw on 2018/4/9.
 */
public class terryDownLoadFile {

    public static void main(String args[]) throws java.lang.Exception {

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(FileWS.class);
        factory.setAddress("http://localhost:8762/soap/user");

        FileWS fileWS = factory.create(FileWS.class);
        CxfFileWrapper fileWrapper = fileWS.download();
        OutputStream os = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try

        {
            is = fileWrapper.getFile().getInputStream();

            // 文件在客户端的保存位置
            File dest = new File("d:\\download\\" + fileWrapper.getFileName());
            os = new FileOutputStream(dest);
            bos = new BufferedOutputStream(os);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

            bos.flush();
            System.out.println("下载完成");
        } catch (
                IOException e)

        {
            e.printStackTrace();
        } finally

        {
            if (bos != null) {
                try {
                    bos.close();
                } catch (Exception e) {
                }
            }

            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
