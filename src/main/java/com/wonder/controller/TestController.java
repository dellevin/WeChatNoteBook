package com.wonder.controller;

import com.wonder.utils.getToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {
    @RequestMapping("/hello")
    public String test() throws IOException {
        return "hello";
    }
}
