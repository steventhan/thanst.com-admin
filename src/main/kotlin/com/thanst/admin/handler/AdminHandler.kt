package com.thanst.admin.handler

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait
import reactor.core.publisher.Mono
import java.security.Principal

@Component
class AdminHandler {
    fun adminPage(req: ServerRequest): Mono<ServerResponse> {
        println("in handler")
        return req.principal()
                .flatMap { maybeOAuthToken ->
                    when(maybeOAuthToken) {
                        is OAuth2AuthenticationToken -> {
                            ServerResponse.ok().render("index")
                        }
                        else -> ServerResponse.badRequest().build()
                    }
                }
    }
}