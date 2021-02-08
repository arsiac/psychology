package top.arsiac.psychology;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>心理学院-网关</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/26
 */
@EnableEurekaClient
@SpringBootApplication
public class PsychologyGatewayApplication {
    public static void main( String[] args ) {
        SpringApplication.run(PsychologyGatewayApplication.class);
    }
}
