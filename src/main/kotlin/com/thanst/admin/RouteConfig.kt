package com.thanst.admin

import com.thanst.admin.filter.AdminFilter
import com.thanst.admin.handler.AdminHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class RouteConfig {

    @Bean
    fun adminRoutes(adminHandler: AdminHandler):
            RouterFunction<ServerResponse> {
        return route(GET("/"), HandlerFunction(adminHandler::adminPage))
    }
}