package com.guardlbt.controller;

import com.guardlbt.common.util.Result;
import com.guardlbt.config.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("fdfs")
public class FdfsController {
    @Autowired
    private FastDFSClient fastDFSClient;
//    @Autowired
//    private PictureService pictureService;

    @PostMapping
    public Result upload(MultipartFile uploadFile) {
        try {
            String s = fastDFSClient.uploadFile(uploadFile);
//            PictureSaveDto pic = new PictureSaveDto();
//            pic.setUrl(s);
//            pic.setCreateTime(new Date());
//            pic.setUpdateTime(new Date());
//            pic.setIsThumbImage(1);
//            pic.setStatus(1);
//            pictureService.insert(pic);
            return Result.ok(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.error(500, "上传出错！");
    }


    @DeleteMapping
    public Result delete(String url) {
        if(url==null){
            return Result.ok();
        }
        if(url.indexOf(";")!=0) {
            String[] split = url.split(";");
            Arrays.stream(split).forEach(item -> {
                if (item != null) {
//                    Picture pic = new Picture();
//                    pic.setUrl(item);
//                    pictureService.delete(pic);
                    fastDFSClient.deleteFile(item);
                }
            });
        }else {
//            Picture pic = new Picture();
//            pic.setUrl(url);
//            pictureService.delete(pic);
            fastDFSClient.deleteFile(url);
        }
        return Result.ok();
    }
}
