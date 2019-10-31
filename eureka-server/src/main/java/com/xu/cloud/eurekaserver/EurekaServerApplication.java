package com.xu.cloud.eurekaserver;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * @author xuzhuang
 * 这个工程启动，是为了作为服务注册。后面所有的微服务，都注册在这个里面，统一管理
 */
@SpringBootApplication
@EnableEurekaServer // 表示它是个注册中心服务器
public class EurekaServerApplication {

    public static void main(String[] args) {
        int port = 8761;
        if(!NetUtil.isUsableLocalPort(port)){
            System.err.printf("端口%d被占用", port);
            System.exit(1);
        }
        new SpringApplicationBuilder(EurekaServerApplication.class).properties("server.port=" + port).run(args);
    }

}
