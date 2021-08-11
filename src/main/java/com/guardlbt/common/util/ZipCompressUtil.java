package com.guardlbt.common.util;

import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;

@Slf4j
public class ZipCompressUtil {

    /**
     * 压缩
     *
     * @param srcFile 源目录
     * @param dest    要压缩的目录
     * @param passwd  密码 不是必填
     * @throws ZipException 异常
     */
    public static void zip(String srcFile, String dest, String passwd) throws ZipException {

        File srcfile = new File(srcFile);
        //创建目标文件
        String destname = buildDestFileName(srcfile, dest);
        ZipParameters par = new ZipParameters();
        par.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        par.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        if (passwd != null) {
            par.setEncryptFiles(true);
            par.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
            par.setPassword(passwd.toCharArray());
        }
        ZipFile zipfile = new ZipFile(destname);
        if (srcfile.isDirectory()) {
            zipfile.addFolder(srcfile, par);
        } else {
            zipfile.addFile(srcfile, par);
        }
    }


    public static String buildDestFileName(File srcfile, String dest) {
        if (dest == null) {
            if (srcfile.isDirectory()) {
                dest = srcfile.getParent() + File.separator + srcfile.getName() + ".zip";
            } else {
                String filename = srcfile.getName().substring(0, srcfile.getName().lastIndexOf("."));
                dest = srcfile.getParent() + File.separator + filename + ".zip";
            }
        } else {
            createPath(dest);//路径的创建
            if (dest.endsWith(File.separator)) {
                String filename = "";
                if (srcfile.isDirectory()) {
                    filename = srcfile.getName();
                } else {
                    filename = srcfile.getName().substring(0, srcfile.getName().lastIndexOf("."));
                }
                dest += filename + ".zip";
            }
        }
        return dest;
    }

//    private static String filePath;
//
//    @Value(("${filePath}"))
//    public void setFilePath(String filePath) {
//        ZipCompressUtil.filePath = filePath;
//    }

    private static void createPath(String dest) {
        File destDir = null;
        if (dest.endsWith(File.separator)) {
            destDir = new File(dest);//给出的是路径时
        } else {
            destDir = new File(dest.substring(0, dest.lastIndexOf(File.separator)));
        }

        if (!destDir.exists()) {
            destDir.mkdirs();
        }
    }
}
