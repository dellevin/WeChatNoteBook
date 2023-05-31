package com.wonder.utils;

import java.util.Arrays;

public class TextSplitter {
    public static void main(String[] args) {
        String text = "#笔记#随笔:test";
        String extractedText = extractTextBetweenHashAndColon(text);

        System.out.println("标签内容：" + Arrays.toString(splitTextByHash(extractedText)));
    }

    public static String extractTextBetweenHashAndColon(String text) {
        int firstHashIndex = text.indexOf("#");
        int firstColonIndex = text.indexOf(":");

        if (firstHashIndex != -1 && firstColonIndex != -1 && firstColonIndex > firstHashIndex) {
            return text.substring(firstHashIndex + 1, firstColonIndex);
        } else {
            return "找不到标签,请查看冒号是否为英文符号";
        }
    }
    //按照#针对标签进行分割
    public static String[] splitTextByHash(String text) {
        return text.split("#");
    }

    public static int findFirstColonIndex(String text) {
        return text.indexOf(":");
    }
}
