package cn.foxluo.alumni_club.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    //api接口包扫描路径
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "cn.foxluo.alumni_club";

    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("校友汇") //设置文档的标题
                .description("校友汇 API 接口文档\n统一接口返回格式:{" +
                            "\n\tcode:200(请求成功)/400(请求失败)/401(签名未认证/未登录)/404(接口不存在)/500(服务器内部错误)"+
                            "\n\tmessage:接口返回信息概述"+
                            "\n\tdata:{" +
                                "\n\t\t\t具体返回数据(需自己手动获取查看)"+
                                "\n\t\t}"+
                        "\n}") // 设置文档的描述
                .version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
                .termsOfServiceUrl("http://www.foxluo.cn") // 设置文档的License信息->1.3 License information
                .build();
    }
}