package com.guardlbt.https;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Map;

public class HttpsUtil {

    public static String get = "GET";
    public static String post = "POST";

    public static String send(String url, String method, Map<String, String> map) throws Exception {
        //设置可通过ip地址访问https请求
        HttpsURLConnection.setDefaultHostnameVerifier(new NullHostNameVerifier());
        TrustManager[] tm = {new MyX509TrustManager()};
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tm, new java.security.SecureRandom());
        // 从上述SSLContext对象中得到SSLSocketFactory对象
        SSLSocketFactory ssf = sslContext.getSocketFactory();
        String urlStr = url;
        URL url1 = new URL(urlStr);
        HttpsURLConnection con = (HttpsURLConnection) url1.openConnection();
        con.setSSLSocketFactory(ssf);
        con.setRequestMethod(method); // 设置以POST方式提交数据
        con.setDoInput(true); // 打开输入流，以便从服务器获取数据
        con.setDoOutput(true);// 打开输出流，以便向服务器提交数据
        //设置发送参数
        if (map != null) {
            StringBuffer sb = new StringBuffer();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey() + "=" + entry.getValue());
                sb.append("&");
            }
            String param = sb.toString();
//        String param = "sfmc=测试";
            PrintWriter out = new PrintWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
            out.print(param);
            out.flush();
            out.close();
        }
        //读取请求返回值
        InputStreamReader in = new InputStreamReader(con.getInputStream(), "UTF-8");
        BufferedReader bfreader = new BufferedReader(in);
        String result = "";
        String line = "";
        while ((line = bfreader.readLine()) != null) {
            result += line;
        }
        return result;
    }
}
