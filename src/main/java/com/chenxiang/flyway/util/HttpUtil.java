package com.chenxiang.flyway.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
/**
 * @author cx
 * @version 1.0
 * @date 2020/9/1 16:37
 */
public class HttpUtil {

    /**
     * get请求
     * @return
     */
    public static String doGet(String url) {
        try {
            HttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());
                return strResult;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * post请求（用于请求json格式的参数）
     * @param url
     * @param params
     * @return
     */
    public static  String doPost(String url, String params) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);// 创建httpPost请求
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        String charSet = "UTF-8";
        //NameValuePair user = new NameValuePair("data", params.toString());
        //NameValuePair[] data = new NameValuePair[]{user};
        StringEntity entity = new StringEntity(params, charSet);// 模拟表单
        httpPost.setEntity(entity);
        HttpResponse response = httpclient.execute(httpPost);// 执行http请求
        StatusLine status = response.getStatusLine();
        int state = status.getStatusCode();
        if (state == HttpStatus.SC_OK) {
            HttpEntity responseEntity = response.getEntity();
            String jsonString = EntityUtils.toString(responseEntity);
            System.out.println(jsonString);
            return jsonString;
        }
        return null;
    }

}
