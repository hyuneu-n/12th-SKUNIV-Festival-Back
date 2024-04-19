package Skufestivalback.skufestival.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "2024skufestival API", description = "2024 서경대학교 축제 부스 안내", version = "v1")
)
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi lostItemOpenApi() {
        return GroupedOpenApi.builder()
                .group("2024skufestival-api")
                .pathsToMatch("/api/**")
                .build();
    }
}