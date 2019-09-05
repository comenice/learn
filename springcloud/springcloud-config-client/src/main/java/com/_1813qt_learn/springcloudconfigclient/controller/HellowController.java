package com._1813qt_learn.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "hellow" )
public class HellowController {

    //属性注入
    @Value("${name}")
    String name;


    @RequestMapping("")
    public String hi(){
        return "hi : " + name;
    }

}
