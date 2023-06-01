package com.wonder.utils;

public class SaveSqlText {
    public  String resSavaText(String getUserMessage) {
        String saveText="";//保存到数据库中的文本消息
        int startIndex = getUserMessage.indexOf("<笔记>");
        if (startIndex != -1) {
            startIndex += "<笔记>".length(); // 将startIndex指向<笔记>之后的位置
            saveText = getUserMessage.substring(startIndex).trim();
        }
        return  saveText;
    }
}
