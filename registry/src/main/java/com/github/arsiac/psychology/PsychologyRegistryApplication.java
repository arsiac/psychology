package com.github.arsiac.psychology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>注册中心</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/26
 */
@EnableEurekaServer
@EnableCaching
@SpringBootApplication
public class PsychologyRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PsychologyRegistryApplication.class, args);
    }
}
