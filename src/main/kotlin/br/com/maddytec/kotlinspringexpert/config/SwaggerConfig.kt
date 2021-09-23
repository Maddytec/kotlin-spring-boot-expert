package br.com.maddytec.kotlinspringexpert.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun springExpertSwagger()  = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.com.maddytec"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(metaData())


    private fun metaData() = ApiInfoBuilder()
            .title("Kotlin Expert")
            .description("API de Exemplos Kotlin")
            .version("1.0.0")
            .build()
}