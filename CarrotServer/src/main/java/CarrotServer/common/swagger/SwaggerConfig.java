package CarrotServer.common.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "DO SOPT Carrot",
                description = "DO SOPT Carrot API Documentation",
                version = "v1"))
@Configuration
public class SwaggerConfig {
}