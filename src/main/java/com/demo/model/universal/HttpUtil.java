package com.demo.model.universal;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
//    @SuppressWarnings("unused")
//    private static final String DEFAULT_CHARSET = "UTF-8";

    public static String sendJsonWithPost(String url, JSONObject jsonObject, String encoding){

        String body = "";
        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        //装填参数
        StringEntity s = new StringEntity(jsonObject.toString(), "utf-8");
        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                "application/json"));
        //设置参数到请求对象中
            httpPost.setEntity(s);
	        System.out.println("请求地址："+url);
	        System.out.println("请求参数："+s.toString());

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
//	        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
        } catch (ClientProtocolException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();

            logger.error("sendJsonWithPost请求提交失败，ClientProtocolException:" , e1);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            logger.error("sendJsonWithPost请求提交失败，IOException:" , e1);
        }
        //获取结果实体
        assert response != null;
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            try {
                body = EntityUtils.toString(entity, encoding);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                logger.error("sendJsonWithPost转换"+encoding+"失败，ParseException:" , e);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                logger.error("sendJsonWithPost转换"+encoding+"失败，IOException:" , e);
            }
        }
        try {
            EntityUtils.consume(entity);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("sendJsonWithPost转换未全部完成，IOException:" , e);
        }
        //释放链接
        try {
            response.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("sendJsonWithPost关闭流失败，IOException:" , e);
        }
        return body;
    }
}
