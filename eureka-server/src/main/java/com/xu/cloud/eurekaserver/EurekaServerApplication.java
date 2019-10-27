package com.xu.cloud.eurekaserver;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        int port = 8761;
        if(NetUtil.isUsableLocalPort(port)){
            System.err.printf("端口%d被占用", port);
            System.exit(1);
        }
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
