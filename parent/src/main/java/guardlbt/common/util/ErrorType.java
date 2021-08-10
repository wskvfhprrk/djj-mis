package guardlbt.common.util;

import java.util.HashMap;
import java.util.Map;

public class ErrorType {

	public final static Map<Integer,String> ERROR_HELPER=new HashMap<>();

	public  final static int SAVE_FAIL=101;//新增失败
	public  final static int UPDATE_FAIL=102;//修改失败
	public  final static int DELETE_FAIL=103;//删除失败
	public  final static int SELECT_FAIL=104;//查询失败
	public  final static int DELETE_FAIL_DEPT=105;//部门已被使用，删除失败
	public  final static int DELETE_FAIL_ROLE=106;//角色已被使用，删除失败

	static {
		ERROR_HELPER.put(SAVE_FAIL,"新增失败!");
		ERROR_HELPER.put(UPDATE_FAIL,"修改失败!");
		ERROR_HELPER.put(DELETE_FAIL,"删除失败!");
		ERROR_HELPER.put(SELECT_FAIL,"查询失败!");
		ERROR_HELPER.put(DELETE_FAIL_DEPT,"部门已被使用，删除失败");
		ERROR_HELPER.put(DELETE_FAIL_ROLE,"角色已被使用，删除失败");
	}

	/**
	 * 根据响应码返回响应信息
	 * @param respCode  响应码
	 * @return 响应码对应的描述信息
	 */
	public static String getRespMsg(int respCode) {
		return ERROR_HELPER.get(respCode) != null ? ERROR_HELPER.get(respCode) : "响应码" + respCode + "] 未定义！";
	}
}
