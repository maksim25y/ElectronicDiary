package ru.mudan.NauJava.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "Проект Naumen 2024",
        description = "Электронный дневник для школьника", version = "1.0.0",
        contact = @Contact(
            name = "GitHub",
            url = "https://github.com/maksim25y/ElectronicDiary"
        )
    )
)
public class SwaggerConfig { }
