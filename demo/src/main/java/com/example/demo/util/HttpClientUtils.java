package com.example.demo.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.vo.UserInfo;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * 配置千万条，集群第一条，环境不匹配，战友两行泪。
  *                                      ——《流浪程序猿》
  * @Author 浮白
  * @className HttpClientUtils
  * @Description http请求工具
  * @Date 13:45 2019/4/27
  **/
public class HttpClientUtils {

    private static final CloseableHttpClient httpclient = HttpClients.createDefault();

    // utf-8字符编码
    public static final String CHARSET_UTF_8 = "utf-8";

    // HTTP内容类型。
    public static final String CONTENT_TYPE_TEXT_HTML = "text/xml";

    // HTTP内容类型。相当于form表单的形式，提交数据
    public static final String CONTENT_TYPE_FORM_URL = "application/x-www-form-urlencoded";

    // HTTP内容类型。相当于form表单的形式，提交数据
    public static final String CONTENT_TYPE_JSON_URL = "application/json;charset=utf-8";




     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description get请求，无参数
      * @Date 13:49 2019/4/27
      * @Param url 请求连接
      * @return
      **/
    public static String sendGet(String url) {
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String result = null;
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
     * @Author 浮白
     * @Description post请求，无参数
     * @Date 13:49 2019/4/27
     * @Param url 请求连接
     * @return
     **/
    public static String sendPost(String url) {
        HttpPost httppost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }



     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description 接口请求基础类
      * @Date 17:41 2019/4/27
      * @Param
      * @return
      **/
    public static String sendPost(HttpPost httpPost) {
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    



     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description //TODO
      * @Date 14:03 2019/4/27
      * @Param url 请求连接
      * @Param map 请求参数
      * @return
      **/
    public static String sendGet(String url, Map<String, Object> map) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for(Map.Entry<String,Object> entry : map.entrySet())
        {
            pairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue().toString()));
        }
        CloseableHttpResponse response = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            builder.setParameters(pairs);
            HttpGet get = new HttpGet(builder.build());
            response = httpClient.execute(get);
            if(response != null && response.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity entity = response.getEntity();
                result = entityToString(entity);
            }
            return result;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                if(response != null)
                {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


        /**
         * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
         * @Author 浮白
         * @Description //TODO
         * @Date 13:51 2019/4/27
         * @Param url 请求地址
         * @Param map 请求参数
         * @return
         **/
    public static String sendPost(String url, Map<String, String> map) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for(Map.Entry<String,String> entry : map.entrySet())
        {
            pairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
        }
        CloseableHttpResponse response = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));
            response = httpClient.execute(post);
            if(response != null && response.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity entity = response.getEntity();
                result = entityToString(entity);
            }
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                if(response != null)
                {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }


    public static String sendPostJsonList(String url,List list) {
        HttpPost httpPost = new HttpPost(url);// 创建httpPost
        try {
            //设置消息头
            httpPost.setHeader("Content-Type",CONTENT_TYPE_JSON_URL);
            httpPost.setHeader("Accept","application/json");
            httpPost.setEntity(new StringEntity(JSON.toJSONString(list),"UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendPost(httpPost);
    }


     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description //TODO
      * @Date 17:34 2019/4/28
      * @Param url 请求地址
      * @Param paramsJson 请求参数
      * @Param authorization 授权凭证
      * @return
      **/
    public static String sendPostJson(String url, String paramsJson,String authorization) {
        HttpPost httpPost = new HttpPost(url);// 创建httpPost
        try {
            // 设置参数
            if (paramsJson != null && paramsJson.trim().length() > 0) {
                httpPost.setHeader("Content-Type",CONTENT_TYPE_JSON_URL);
                httpPost.setHeader("Accept","application/json");
                httpPost.setHeader("Authorization","Bearer "+authorization);
                StringEntity stringEntity = new StringEntity(paramsJson, "UTF-8");
                httpPost.setEntity(stringEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendPost(httpPost);
    }



     /**
      * 配置千万条，集群第一条，环境不匹配，战友两行泪。 ——《流浪程序猿》
      * @Author 浮白
      * @Description 实体转换工具
      * @Date 14:01 2019/4/27
      * @Param entity 访问实体
      * @return
      **/
    private static String entityToString(HttpEntity entity) throws IOException {
        String result = null;
        if(entity != null)
        {
            long lenth = entity.getContentLength();
            if(lenth != -1 && lenth < 2048)
            {
                result = EntityUtils.toString(entity,"UTF-8");
            }else {
                InputStreamReader reader1 = new InputStreamReader(entity.getContent(), "UTF-8");
                CharArrayBuffer buffer = new CharArrayBuffer(2048);
                char[] tmp = new char[1024];
                int l;
                while((l = reader1.read(tmp)) != -1) {
                    buffer.append(tmp, 0, l);
                }
                result = buffer.toString();
            }
        }
        return result;
    }




}
