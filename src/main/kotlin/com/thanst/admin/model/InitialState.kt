package com.thanst.admin.model

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.oauth2.core.user.OAuth2User

val objectMapper = ObjectMapper()

class InitialState(val oauth2User: OAuth2User) {
    fun toJson(): String {
        return objectMapper.writeValueAsString(this)
    }
}