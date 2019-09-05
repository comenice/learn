package com._1813qt.learn.springcloudconfigserver;

import com._1813qt.learn.springcloudconfigserver.config.TestFactories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@SpringBootApplication
@EnableConfigServer
@RestController
@RequestMapping("test")
public class SpringcloudConfigServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringcloudConfigServerApplication.class, args);
    }

    @RequestMapping("")
    public String fac() {
        HashMap hashMap = new HashMap();
        return hashMap.get("name").toString();
    }

}
