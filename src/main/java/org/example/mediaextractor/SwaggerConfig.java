package org.example.mediaextractor;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "MediaExtractor",
                description = "MediaExtractor",
                version = "1.0.0",
                contact = @Contact(
                        name = "Mehdi",
                        email = "mehdiesedof@gmail.com",
                        url = "mehdiasadov.com")
        ))
public class SwaggerConfig {
}
