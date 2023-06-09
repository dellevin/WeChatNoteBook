package com.wonder.service.impl;

import com.wonder.entity.Message;
import com.wonder.entity.UserAndNote;
import com.wonder.entity.WechatNote;
import com.wonder.entity.WechatUser;
import com.wonder.mapper.UserAndNoteMapper;
import com.wonder.mapper.WechatNoteMapper;
import com.wonder.mapper.WechatUserMapper;
import com.wonder.service.WechatService;
import com.wonder.utils.PasswordUtils;
import com.wonder.utils.ResMessage;
import com.wonder.utils.SaveSqlText;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;


@Service
public class WechatServiceImpl implements WechatService {
    @Resource
    WechatUserMapper wechatUserMapper;
    @Resource
    WechatNoteMapper wechatNoteMapper;
    @Resource
    UserAndNoteMapper userAndNoteMapper;


    @Override
    public Object userMessageHandle(Message requestMessage) throws IOException {

        String context="";//预创建回复消息的文本
        SaveSqlText saveSqlText = new SaveSqlText();//保存到数据库中的文本消息
        WechatNote wechatNote = new WechatNote();
        UserAndNote userAndNote = new UserAndNote();

        String returnPassword="";
        returnPassword=PasswordUtils.randomPassword(16);
        ResMessage resMes = new ResMessage();//回复消息
        WechatUser wechatUser = new WechatUser();//微信用户 包括用户的openid和密码

        System.out.println("post方法入参："+requestMessage);
        //获取 开发者微信号
        String toUserName = requestMessage.getToUserName();
        // 获取 用户发送的消息内容
        String getUserMessage =  requestMessage.getContent();
        //获取 发送方账号（一个OpenID） 用户
        String fromUserName = requestMessage.getFromUserName();

        if(wechatUserMapper.getUseIsExist(fromUserName)!=1){//用户不存在创建用户
            if(getUserMessage!=null && getUserMessage.equals("创建用户"))
            {
                wechatUser.setUserName(fromUserName);
                wechatUser.setUserPassword(returnPassword);
                wechatUserMapper.insert(wechatUser);
                System.out.println("创建用户-----用户发送的消息："+getUserMessage);
                //这个是响应消息内容
                context="创建用户成功，请重新发送消息记录该条笔记";
            }else{
                context="请先创建用户";
            }
        }else {//用户存在继续下一步操作
            //从数据库获取用户的用户名和信息
            returnPassword=wechatUserMapper.getUsePassword(fromUserName);
            if(getUserMessage!=null)//如果发送的消息不为空
            {
                System.out.println("搜索用户-----用户发送的消息："+getUserMessage);
                if(getUserMessage.substring(0,4).equals("<笔记>")){//表示这个是需要保存的笔记

                    String saveText = saveSqlText.resSavaText(getUserMessage);
                    wechatNote.setNoteContext(saveText);
                    wechatNote.setNoteTime(new Date());
                    wechatNoteMapper.insert(wechatNote);

                    userAndNote.setUserID( wechatUserMapper.getUseID(fromUserName) );
                    userAndNote.setNoteID( wechatNoteMapper.getNoteID(saveText) );
                    userAndNoteMapper.insert(userAndNote);
                }
                //这个是响应消息内容
                context="笔记已记录,若需在线查看请在浏览器中访问网址并输入账户和密码。\n" +
                        "网址：www.xxxxx.com\n" +
                        "账户："+fromUserName+"\n" +
                        "密码："+ returnPassword+"\n"+
                        "请妥善保存账户和密码,切勿告诉其他人.";
            }else {
                context="请按照要求发送需要保存的笔记！";
            }
        }

        //回复消息包含了网址,账户以及密码等关键内容
        return resMes.toMessage(toUserName,fromUserName,context);
    }
}
