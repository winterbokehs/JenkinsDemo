package com.example.demo.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class HttpURLConnectionUtil  {
    /**
     * 返回数组
     * @param urlString
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String getResult(String urlString, Class<T> t){

        URL url;
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String line = null;
        try {
            url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();// 根据URL生成HttpURLConnection
            connection.setRequestMethod("GET");// 默认GET请求
            connection.connect();// 建立TCP连接
            connection.setConnectTimeout(30000); //超时自动关闭
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));// 发送http请求
                StringBuilder result = new StringBuilder();
                // 循环读取流
                while ((line = reader.readLine()) != null) {
                    result.append(line).append(System.getProperty("line.separator"));
                }
                String realRes = result.toString().replaceAll("\\\\", "");
                List<T> ts = JSONArray.parseArray(realRes, t);
                return   JSON.toJSONString(ts);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "获取数据失败";
    }

    /**
     * 返回对象
     * @param urlString
     * @param t
     * @param <T>
     * @return
     */
    public static  <T> String getResultObj(String urlString, Class<T> t){

        URL url;
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String line = null;
        try {
            url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();// 根据URL生成HttpURLConnection
            connection.setRequestMethod("GET");// 默认GET请求
            connection.connect();// 建立TCP连接
            connection.setConnectTimeout(30000); //超时自动关闭
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));// 发送http请求
                StringBuilder result = new StringBuilder();
                // 循环读取流
                while ((line = reader.readLine()) != null) {
                    result.append(line).append(System.getProperty("line.separator"));
                }
                String realRes = result.toString().replaceAll("\\\\", "").replaceAll("\\[", "").replaceAll("\\]", "");
                String s = JSONObject.toJSONString(realRes);
                return s;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "获取数据失败";
    }

}
