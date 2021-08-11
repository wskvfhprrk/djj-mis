package com.guardlbt.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: hejz
 * @Description:
 * @Date: 2019/11/20 16:41
 */
public class CreateCsvUtil {
    /**
     * CSV文件生成方法
     *
     * @param head       文件头
     * @param dataList   数据列表
     * @param outPutPath 文件输出路径
     * @param filename   文件名
     * @return
     */
    public static File createCSVFile(List<Object> head, List<List<Object>> dataList, String outPutPath, String filename) {

        File csvFile = null;
        BufferedWriter csvWtriter = null;
        try {
            csvFile = new File(outPutPath + File.separator + filename + ".csv");
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            // GB2312使正确读取分隔符","
            csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                    csvFile), "UTF-8"), 1024);
            // 写入文件头部
            writeRow(head, csvWtriter);
            csvWtriter.newLine();

            // 写入文件内容
            for (int i = 0; i < dataList.size(); i++) {
                if(i==dataList.size()-1){
                    writeRow(dataList.get(i), csvWtriter);
                }else {
                    writeRow(dataList.get(i), csvWtriter);
                    csvWtriter.newLine();
                }
            }
            csvWtriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvWtriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }

    /**
     * 写一行数据方法
     *
     * @param row
     * @param csvWriter
     * @throws IOException
     */
    private static void writeRow(List<Object> row, BufferedWriter csvWriter) throws IOException {
        for (int i = 0; i < row.size(); i++) {
            StringBuffer sb = new StringBuffer();
            if (i == row.size() - 1) {
                sb.append(row.get(i));
            } else {
                sb.append(row.get(i)).append(",");
            }
            csvWriter.write(sb.toString());
        }
    }


    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        List<Object> exportData = new ArrayList<Object>();
        exportData.add("第一列");
        exportData.add("第二列");
        exportData.add("第三列");
        List<List<Object>> datalist = new ArrayList<List<Object>>();
        List<Object> data = new ArrayList<Object>();
        data.add("111");
        data.add("222");
        data.add("333");
        List<Object> data1 = new ArrayList<Object>();
        data1.add("2313");
        data1.add("555");
        data1.add("666");
        datalist.add(data);
        datalist.add(data1);
        String path = "d:/exportCsv/";
        String fileName = "文件导出";

        File file = createCSVFile(exportData, datalist, path, fileName);
        String fileName2 = file.getName();
        System.out.println("文件名称：" + fileName2);
        System.out.println("filt:" + file.getPath());
    }
}
