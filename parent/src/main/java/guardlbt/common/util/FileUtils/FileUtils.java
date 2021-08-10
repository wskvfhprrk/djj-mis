package guardlbt.common.util.FileUtils;

import guardlbt.common.exception.ResultException;
import guardlbt.common.util.ResultErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//获取数据，生成流，写入文件
@Component
@Slf4j
//@PropertySource("classpath:DataConfig.properties")
public class FileUtils {

	// 数据转换
	public void  createFile(List<Map<String, Object>> data,String baseUrl,Object batch) throws Exception {
		//1文件格式转换
		List<String> result = new ArrayList<>();
		for (Map<String, Object> item : data) {
			StringBuilder sb = new StringBuilder();
			for (String key : item.keySet()) {
				Object value = item.get(key);
				sb.append(value + ",");
			}
			sb.deleteCharAt(sb.length() - 1);
			result.add(sb.toString());
		}
		
		//2生成文件
		createCSVFile(result,baseUrl,batch);
	}

	// 生成csv文件
	public void createCSVFile(List<String> data,String baseUrl,Object batch) throws Exception {
		//1生成csv文件
		String csvUrl = baseUrl+batch + ".csv";
		String zipUrl = baseUrl+batch+".zip";
		BufferedWriter csvFileOutputStream = null;		
		try {
			File file = new File(csvUrl);
			if (!file.exists()) {
				file.createNewFile();
			}
			csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"), 1024);
			for (String item : data) {
				 StringBuffer sb = new StringBuffer();		        
		         csvFileOutputStream.write(item);
		         csvFileOutputStream.newLine();
			}							      					
		} finally {
			if(csvFileOutputStream!=null) {
			csvFileOutputStream.close();}
		}
		
		//2创建zip
		createZip(csvUrl,zipUrl);
	}
	
	
	
    
	
	private void createZip(String csvUrl,String zipUrl) throws Exception {
		FileInputStream fis=null;
		ZipOutputStream zo = null;
		File csvFile=new File(csvUrl);
		if(!csvFile.exists()) {
			throw new ResultException(ResultErrorCode.FILE_NO_FIND);
		}
		
		File zipFile=new File(zipUrl);
		if(!zipFile.exists()) {
			zipFile.createNewFile();
		}
		
		 byte[] buf = new byte[8192];
	     int len;
		try {
			fis=new FileInputStream(csvFile);
			zo=new ZipOutputStream(new FileOutputStream(zipFile));
			ZipEntry ze = new ZipEntry(csvFile.getName());
			zo.putNextEntry(ze);
			  while ( ( len = fis.read( buf ) ) > 0 ) {
	                zo.write(buf, 0, len );
	            }
			  zo.flush();
		}catch(Exception e){
			e.printStackTrace();
			throw new ResultException(ResultErrorCode.IO_EXCEPTION);
		}finally {
			if(fis!=null) {
				fis.close();
			}
			if(zo!=null) {
				zo.close();
			}
		}
		//删除没用的文件
		csvFile.delete();
		
	}

}
