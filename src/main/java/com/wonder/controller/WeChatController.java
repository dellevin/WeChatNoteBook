package com.wonder.controller;

import com.wonder.entity.Message;
import com.wonder.service.WechatService;
import com.wonder.utils.WechatUtils;
import com.wonder.utils.getToken;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/wechat")
public class WeChatController {
    @RequestMapping("/hello")
    public String test() throws IOException {
        return getToken.pushAccessToken();
    }
    /**
     * 微信接口验证
     * @param request 请求参数
     * @return String
     */
    //改成GetMapping
    @GetMapping
    public String check(HttpServletRequest request){
        System.out.println("get方法");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        //MDpgWKeQxj4yTf 是自己的token
        if (WechatUtils.checkSignature(signature, timestamp, nonce,"MDpgWKeQxj4yTf")) {
            System.out.println("检验通过");
            return echostr;
        }else {
            System.out.println("检验不通过");
            return "校验不通过";
        }
    }

    @Autowired
    WechatService wechatService;
    /**
     * 消息处理
     * @param requestMessage 请求消息
     * @return 响应消息或者“success”
     */
    
    //改成PostMapping用来接收POST请求，produces指定响应的类型为xml，RequestBody和实体类Message的Xml注解一起实现直接接收xml请求
    @RequestMapping(method = RequestMethod.POST,consumes = "text/xml", produces = "text/xml;charset=utf-8")
    @ApiOperation(value = "回消息")
    public Object message(@RequestBody Message requestMessage) throws Exception {
        Object obj = wechatService.userMessageHandle(requestMessage);
        return obj;
    }
}
