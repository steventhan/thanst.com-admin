package com.thanst.admin.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.method.support.ModelAndViewContainer
import org.springframework.web.reactive.result.view.Rendering
import reactor.core.publisher.Mono

@Controller
class AdminController {
    @GetMapping("/")
    fun adminPage(): Mono<String> {
        return Mono.just("index")
    }
}