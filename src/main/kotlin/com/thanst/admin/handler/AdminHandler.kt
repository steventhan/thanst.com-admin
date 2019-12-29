package com.thanst.admin.controller

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class AdminHandler {
    fun adminPage(req: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok()
                .render("index")
    }
}