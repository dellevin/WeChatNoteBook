package com.wonder.utils;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import java.util.Timer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class getToken {
    public static String  accessToken;
    public static String pushAccessToken() throws IOException {
        Properties properties = new Properties();
        InputStream in = new FileInputStream("src/main/resources/config.properties");
        properties.load(in);
        String weChatAppId = properties.getProperty("weChatAppId");
        String weChatSecret = properties.getProperty("weChatSecret");
        //判断accessToken是否为空
        if(accessToken!=null){
            //System.out.println("内存里面的"+accessToken);
            return accessToken;
        }else {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                    + weChatAppId
                    +"&secret="
                    + weChatSecret;
            JSONObject jsonObject = getResponse(url);
            System.out.println(jsonObject);
            if(jsonObject.containsKey("expires_in")){
                //获取微信的access_token
                accessToken = jsonObject.getString("access_token");
                //获取微信的 expiresIn 过期时间
                String expiresIn = jsonObject.getString("expires_in");
                // 将expiresIn转换为毫秒数
                long delay = Long.parseLong(expiresIn) * 1000;
                // 设置定时器，在指定时间后执行清除accessToken的任务
                Timer timer = new Timer();
                timer.schedule(new TokenCleanupTask(), delay);
                //将accessToken发送给调用方法
                //System.out.println("重新请求的"+accessToken);
                return accessToken;
            }else{
                throw new RuntimeException("请求不到啊！哥哥");
            }
        }
    }
    static JSONObject getResponse(String url) {
        //调用工具类获通过url获取到html页面的数据，也就是json数据
        String res = HttpUtil.get(url);
        //返回数据，将JSON格式的字符串解析为原始JavaScript值或对象
        return JSONObject.parseObject(res);
    }
}
