package com.wonder.service;


import com.wonder.entity.Message;

public interface WechatService {
     Object userMessageHandle(Message requestMessage) throws Exception;
}
