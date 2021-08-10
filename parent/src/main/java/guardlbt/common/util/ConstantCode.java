package guardlbt.common.util;

public class ConstantCode {
	//账户状态
	public final static Integer NORMAL=0;
	public final static Integer EXCEPTION=1;
	public final static Integer LOCK=2;
	
	//归档间隔时间
	public final static Integer FILE_OUT_DAY=90;
	//清除历史表数据间隔时间
	public final static Integer CREATE_FILE_AND_CLEAN=90;
	//文件生成根路径
	public final static String ROOT_URL="D://work";
	//文件生成相对路径
	public final static String RELATIVE="/test";
	

}
