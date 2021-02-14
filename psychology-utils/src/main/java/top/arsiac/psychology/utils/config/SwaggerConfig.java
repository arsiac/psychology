package top.arsiac.psychology.utils.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * <p>Swagger 配置</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/14
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public SwaggerConfig() {
        System.out.println("SwaggerConfig init");
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //加了ApiOperation注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("top.arsiac.psychology"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Psychology")
                .description("心理学院信息管理系统")
                .termsOfServiceUrl("https://arsiac.top")
                .version("0.0.1")
                .build();
    }
}
