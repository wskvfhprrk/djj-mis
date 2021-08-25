package com.guardlbt;

import com.guardlbt.config.FastDFSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringbootApplicationTest {

    @Autowired
    private FastDFSClient fastDFSClient;

    /**
     * 文件上传
     */
    @Test
    public void uploadTest() {
        InputStream is = null;
        try {
            // 获取文件源
            File source = new File("/Users/hejianzhe/Downloads/lk/WechatIMG21.jpeg");
            // 获取文件流
            is = new FileInputStream(source);
            // 进行文件上传
            String s = fastDFSClient.uploadFile(new File("/Users/hejianzhe/Downloads/lk/WechatIMG21.jpeg"));
            System.out.println("s===" + s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    // 关闭流资源
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void delete() {
        fastDFSClient.deleteFile("http://192.168.5.183:8080/group1/M00/00/13/wKgFt2EjL6qAJwQyAAHoGxkAS5M59.jpeg");
    }
}
