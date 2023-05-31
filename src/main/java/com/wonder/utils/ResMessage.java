package com.wonder.utils;

import com.wonder.entity.Message;

public class ResMessage {
    public  Message toMessage(String toUserName,String fromUserName,String context) {

        //新建一个响应对象
        Message responseMessage = new Message();
        //消息来自谁
        responseMessage.setFromUserName(toUserName);
        //消息发送给谁
        responseMessage.setToUserName(fromUserName);
        //消息类型，返回的是文本
        responseMessage.setMsgType("text");
        //消息创建时间，当前时间
        responseMessage.setCreateTime(System.currentTimeMillis());
        //回复消息的文本
        responseMessage.setContent(context);

        return responseMessage;
    }
}
