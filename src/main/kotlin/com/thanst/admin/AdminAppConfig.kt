package com.thanst.admin

import com.thanst.admin.model.InitialState
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.http.MediaType
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.web.reactive.config.ResourceHandlerRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.server.ServerWebExchange
import org.thymeleaf.spring5.view.reactive.ThymeleafReactiveView
import reactor.core.publisher.Mono
import kotlin.collections.LinkedHashMap

@Configuration
class AdminAppConfig : WebFluxConfigurer {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/js/**")
                .addResourceLocations( "classpath:/static/js/")
    }

    @Bean
    fun webClient(): WebClient = WebClient.create()

    @Bean
    @Scope("prototype")
    fun index(): ThymeleafReactiveView = object : ThymeleafReactiveView() {
        override fun render(model: MutableMap<String, *>?, contentType: MediaType?,
                            exchange: ServerWebExchange): Mono<Void> {
            val newModel = LinkedHashMap(model)
            return exchange.getPrincipal<OAuth2AuthenticationToken>().flatMap { it ->
                newModel["initialState"] = InitialState(oauth2User = it.principal).toJson()
                super.render(newModel, contentType, exchange)
            }
        }
    }
}