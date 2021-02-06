package top.arsiac.psychology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>心理学院-服务注册中心</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/27
 */
@EnableEurekaServer
@SpringBootApplication
public class PsychologyRegistryApplication {
    public static void main( String[] args ) {
        SpringApplication.run(PsychologyRegistryApplication.class, args);
    }
}
