package guardlbt.common.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MatrixToImageWriter {

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    private MatrixToImageWriter() {
    }

    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_BYTE_BINARY);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    public static void writeToFile(BitMatrix matrix, String format, File file)
            throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format "
                    + format + " to " + file);
        }
    }

    public static void writeToStream(BitMatrix matrix, String format,
                                     OutputStream stream) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }

    public static void writePng(String path, String couponBatchCode) throws Exception {
        String text = couponBatchCode; // 二维码内容
        int width = 200; // 二维码图片宽度
        int height = 200; // 二维码图片高度
        String format = "png";// 二维码的图片格式

        Hashtable<EncodeHintType, String> hints = new Hashtable<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码
        //二维码外边距
        hints.put(EncodeHintType.MARGIN, "1");

        BitMatrix bitMatrix = new MultiFormatWriter().encode(text,
                BarcodeFormat.QR_CODE, width, height, hints);
        // 生成二维码 文件地址 是否存在不存在则新增
        File outputFile = new File(path);
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
    }


    public static void writeTxt(String path, String couponBatchCode) throws Exception {
        String text = couponBatchCode; // 二维码内容
        File outputFile = new File(path);
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }
        FileWriter fw = new FileWriter(outputFile);
        fw.write(text);
        fw.close();
    }

    public static void writeXLSX(String totalPath, Set<String> setConpou, String beginTime, String endTime) {
        try {
            // 创建Excel
            HSSFWorkbook workBook = new HSSFWorkbook();
            int i = 1;
            while (true) {
                List<String> collect = setConpou.stream().limit(60000).collect(Collectors.toList());
                HSSFSheet sheet = workBook.createSheet();
                HSSFRow row = sheet.createRow(0);
                row.createCell(0).setCellValue("二维码");
                row.createCell(1).setCellValue("有效时间");
                row.createCell(2).setCellValue("失效时间");
                int count = 0;
                for (String item : collect) {
                    row = sheet.createRow(++count);
                    row.createCell(0).setCellValue(item);
                    row.createCell(1).setCellValue(beginTime);
                    row.createCell(2).setCellValue(endTime);
                }
                setConpou.removeAll(collect);
                if (setConpou.size() == 0) {
                    break;
                }
            }
            File outputFile = new File(totalPath);
            if (!outputFile.getParentFile().exists()) {
                outputFile.getParentFile().mkdirs();
            }
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            workBook.write(outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void writeTxtApend(String path, String couponBatchCode,String manualCode) throws Exception {
        String text = couponBatchCode; // 二维码内容
        File outputFile = new File(path);
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }
        FileWriter fw = new FileWriter(outputFile, true);
        fw.append(text+","+manualCode + "\r\n");
        fw.close();
    }





    public static void main(String[] args) throws Exception {
         String text="1234555227524767";
        String text2="1234555227524768";
        String text3="1234555227524769";
        String text4="1234555227524765";
        String text5="e/yWA7xPoZqvzP1CHVftXYDDRa78Vs6Sdo2+x7zOFlFBRvxfGHVWaJi2R80AJmLyaqVQ90LwbUIy9GI+eEhhvg==";
        String path="D:\\home\\promotion\\new_c9.png";
        writePng(path,text5);
//        String path2=new MatrixToImageWriter().rootPath+ File.separator +"31005"+File.separator+"TXT"+File.separator+"12345_TXT_"+text5+".txt";
//        writeTxt(path2,text5);


       /*
        String text5="1234555227524766";
        String str="D:\\promotion\\promotionserver\\promotionserver\\target\\classes\\12345\\TXT_123457.txt";
        for(int i=0;i<10;i++) {
            writeTxtApend(str, text5);
        }
        */

//        String str2 = "D:\\promotion\\promotionserver\\promotionserver\\target\\classes\\12345\\XLSX_123457.xlsx";
//        Set<Long> codeSet = new HashSet<>();
//        codeSet.add(1231313L);
//        codeSet.add(1233313L);
//        codeSet.add(1234313L);
//        codeSet.add(1235313L);
//        writeXLSX(str2, codeSet, "2019-04-05", "2019-04-31");

    }
}
