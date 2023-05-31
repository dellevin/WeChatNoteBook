package com.wonder.utils;

import java.util.TimerTask;

public class TokenCleanupTask extends TimerTask {
    public void run() {
        // 清除accessToken
        getToken.accessToken = null;
        System.out.println("accessToken 已清除");
    }
}
