package com.github.mewesmee.spring_webflux_employee_manager.configuration;

import com.github.mewesmee.spring_webflux_employee_manager.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class RouterConfig {

    @Bean
    RouterFunction<ServerResponse> routes(UserHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/handler/users").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::getAllUsers)
                .andRoute(RequestPredicates.GET("/handler/users/{userId}").and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), handler::getUserById)
                .andRoute(RequestPredicates.POST("/handler/users").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::create)
                .andRoute(RequestPredicates.PUT("/handler/users/{userId}").and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), handler::updateUserById)
                .andRoute(RequestPredicates.PUT("/handler/users/{userId}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::deleteUserById);
    }
}
