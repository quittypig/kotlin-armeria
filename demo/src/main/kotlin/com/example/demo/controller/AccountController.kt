package com.example.demo.controller

import com.example.account.v1.SignUpRequestV1
import com.example.demo.ApiClient
import com.example.demo.controller.model.SignUpRequest
import com.example.demo.controller.model.SignUpResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class AccountController(
    private val apiClinet: ApiClient
) {
    @ResponseBody
    @PostMapping("/account")
    fun getAccountId(
        @RequestBody signUpRequest: SignUpRequest
    ): SignUpResponse {
        val signUpRequestV1 = SignUpRequestV1.newBuilder()
            .setId(signUpRequest.id)
            .setName(signUpRequest.name)
            .setPassword(signUpRequest.password)
            .build()

        return apiClinet.account().signUp(signUpRequestV1)
            .let {
                SignUpResponse(
                    id = it.id
                )
            }
    }
}
