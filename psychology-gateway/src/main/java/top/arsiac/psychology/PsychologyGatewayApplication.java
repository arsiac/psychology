package top.arsiac.psychology;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * <p>心理学院-网关</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/26
 */
@EnableOpenApi
@EnableEurekaClient
@SpringBootApplication
public class PsychologyGatewayApplication {
    public static void main( String[] args ) {
        SpringApplication.run(PsychologyGatewayApplication.class);
    }
}
