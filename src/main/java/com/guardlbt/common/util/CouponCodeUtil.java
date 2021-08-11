package com.guardlbt.common.util;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

public class CouponCodeUtil {


    /**
     * 生成手工码
     * @return
     */
    public static String generateCodeManualNo(String batchNo){

         if(batchNo.length()<=2){
             batchNo=batchNo.length()==1?"0"+batchNo:batchNo;
         }else  {
             batchNo=batchNo.substring(batchNo.length()-2,batchNo.length());
         }
        String code=batchNo+RandomStringUtils.randomNumeric(7);
        return   code+securityManualCodeNo(code);
    }





    /**
     * 生成券码
     * 	<pre>
     * 		规则：电子券批号5位+9位随机数+1位验证码 = 15位
     * </pre>
     * @return
     */
    public static Long generateCodeNo(String batchNo){
          String code=batchNo+RandomStringUtils.randomNumeric(9);
          return  Long.parseLong(code+securityCodeNo(code));
    }


    /**
     * 验证码
     * 将前面的码14位数分别乘以不同的系数。从第一位到第十四位的系数分别为：7,10,  4, 2, 1, 6,  8, 4, 2
     * 将这14位数字和系数相乘的结果相加 用加出来和除以11，看余数是多少
     * 余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位码为1 0 9 8 7 6 5 4 3 2
     * @return
     */
    public static char securityManualCodeNo(String codeNo){
        char pszSrc[] = codeNo.toCharArray();
        int iS = 0;
        int iW[] = { 7,10,  4, 2, 1, 6,  8, 4, 2 };
        char szVerCode[] = new char[] { '1', '0', '9', '8', '7', '6', '5', '4', '3', '2' };
        int i;
        for (i = 0; i <9; i++) {
            iS += (int) (pszSrc[i] - '0') * iW[i];
        }
        int iY = iS % 10;
        return szVerCode[iY];
    }


    /**
     * 验证码
     * 将前面的码14位数分别乘以不同的系数。从第一位到第十四位的系数分别为：7, 9, 10, 5, 4, 2, 1, 6, 3, 7, 5, 8, 4, 2；
     * 将这14位数字和系数相乘的结果相加 用加出来和除以11，看余数是多少
     * 余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位码为1 0 X 9 8 7 6 5 4 3 2
     * @return
     */
    public static char securityCodeNo(String codeNo){
        char pszSrc[] = codeNo.toCharArray();
        int iS = 0;
        int iW[] = { 7, 9, 10, 5, 4, 2, 1, 6, 3, 7, 5, 8, 4, 2 };
        char szVerCode[] = new char[] { '1', '0', '9', '8', '7', '6', '5', '4', '3', '2' };
        int i;
        for (i = 0; i < 14; i++) {
            iS += (int) (pszSrc[i] - '0') * iW[i];
        }
        int iY = iS % 10;
        return szVerCode[iY];
    }


    public static void main(String[] args) {
      /*
            Set<Long> setStr=new HashSet<>();
            while (setStr.size()<100000) {
              Long code=CouponCodeUtil.generateCodeNo("31005");
              setStr.add(code);
              System.out.println(code);
            }
            System.out.println("setStr.size()="+setStr.size());
        */

//        char result=CouponCodeUtil.securityCodeNo("310010000073436".substring(0, "310010000073436".length() - 1));
//       System.out.println(result);
//        if(result=="310010000073437".charAt("310010000073437".length()-1)) {
//           System.out.println("true");
//        }else{
//            System.out.println("false");
//        }

//        System.out.println(generateCodeManualNo("1"));
//        System.out.println(generateCodeManualNo("11"));
//        System.out.println(generateCodeManualNo("121"));

       // 0109723996
        //1117854434
       // 2151859281

        System.out.println(securityManualCodeNo("010972399"));
        System.out.println(securityManualCodeNo("111785443"));
        System.out.println(securityManualCodeNo("215185928"));

    }
}
