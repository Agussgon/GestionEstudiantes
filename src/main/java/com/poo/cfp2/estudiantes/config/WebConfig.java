package com.poo.cfp2.estudiantes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//permite solicitudes de otros dominios
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //Permite solicitudes a cualquier URL del servidor.
        registry.addMapping("/**")
                .allowedOrigins("*")//cualquier sitio web pueda hacer solicitudes
                .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
                .allowCredentials(false)//Permite el envío de cookies junto con las solicitudes.
                .allowedHeaders("*");
    }

}
