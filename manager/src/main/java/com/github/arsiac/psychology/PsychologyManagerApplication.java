package com.github.arsiac.psychology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * <p>主要服务</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/3/5
 */
@EnableWebMvc
@EnableEurekaClient
@SpringBootApplication
public class PsychologyManagerApplication {
    /**
     * 服务调用
     * */
    @Bean
    @LoadBalanced
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(PsychologyManagerApplication.class, args);
    }
}
