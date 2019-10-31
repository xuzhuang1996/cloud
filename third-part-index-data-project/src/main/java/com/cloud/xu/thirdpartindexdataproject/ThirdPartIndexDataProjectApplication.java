package com.cloud.xu.thirdpartindexdataproject;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xuzhuang
 * 这个工程启动，只是用了通过接口访问到数据。例如启动后访问http://127.0.0.1:8090/indexes/codes.json，将返回static.indexes包下的codes.json文件内容
 */
@SpringBootApplication
@EnableEurekaClient
public class ThirdPartIndexDataProjectApplication {

    public static void main(String[] args) {
        int port = 8090;
        int eurekaServerPort = 8761;
        if(NetUtil.isUsableLocalPort(eurekaServerPort)) {
            System.err.printf("检查到端口%d 未启用，判断 eureka 服务器没有启动，本服务无法使用，故退出%n", eurekaServerPort );
            System.exit(1);
        }

        // 表示启动的时候如果带了参数，如： port=8099, 那么程序就会使用 8099 作为端口号了。
        // 这样做的好处是，什么代码都不用改，只需要在启动的时候带不同的参数，就可以启动不同的端口了。
        if(args != null && args.length != 0){
            for (String arg : args) {
                if(arg.startsWith("port=")){
                    // subAfter截取分隔字符串之后的字符串，不包括分隔字符串
                    String strPort= StrUtil.subAfter(arg, "port=", true);
                    if(NumberUtil.isNumber(strPort)) {
                        port = Convert.toInt(strPort);
                    }
                }
            }
        }
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ThirdPartIndexDataProjectApplication.class).properties("server.port=" + port).run(args);
    }

}
