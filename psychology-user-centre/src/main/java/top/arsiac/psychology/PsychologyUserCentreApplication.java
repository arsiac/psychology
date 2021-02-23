package top.arsiac.psychology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * <p>心理学院-用户中心</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/27
 */
@EnableWebMvc
@EnableScheduling
@EnableOpenApi
@EnableEurekaClient
@SpringBootApplication
public class PsychologyUserCentreApplication {
    public static void main( String[] args ) {
        SpringApplication.run(PsychologyUserCentreApplication.class, args);
    }
}
