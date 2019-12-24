package com.thanst.admin

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.client.WebClient

@Configuration
@EnableWebFlux
@ComponentScan(basePackages = ["com.thanst.admin"])
class AdminAppConfig : WebFluxConfigurer {
    @Bean
    fun webClient(): WebClient = WebClient.create()

}