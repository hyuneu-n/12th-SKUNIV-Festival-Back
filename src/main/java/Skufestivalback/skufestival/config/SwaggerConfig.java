package Skufestivalback.skufestival.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "2024skufestival API", description = "2024 서경대학교 축제 부스 안내", version = "v1"),
        servers = @Server(url = "https://dev.skufestival2024.site", description = "서버 URL")
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