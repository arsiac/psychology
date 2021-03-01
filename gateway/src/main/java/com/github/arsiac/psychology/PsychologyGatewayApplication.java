package com.github.arsiac.psychology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * <p>API 网关</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/1
 */
@EnableOpenApi
@EnableCaching
@EnableEurekaClient
@SpringBootApplication
public class PsychologyGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PsychologyGatewayApplication.class, args);
    }
}
