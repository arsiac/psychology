package com.github.arsiac.psychology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * <p>用户中心</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/1
 */
@EnableOpenApi
@EnableWebMvc
@EnableEurekaClient
@SpringBootApplication
public class PsychologyCentreApplication {
    public static void main(String[] args) {
        SpringApplication.run(PsychologyCentreApplication.class, args);
    }
}
