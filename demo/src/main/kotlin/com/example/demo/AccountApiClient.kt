package com.example.demo

import com.example.account.v1.AccountRouteV1Grpc
import com.example.account.v1.SignUpRequestV1
import com.example.account.v1.SignUpResponseV1
import com.linecorp.armeria.client.Clients

class AccountApiClient {
    private val accountRouteV1Service = Clients.newClient(
        "gproto+http://127.0.0.1:8080/",
        AccountRouteV1Grpc.AccountRouteV1BlockingStub::class.java
    )

    fun signUp(request: SignUpRequestV1): SignUpResponseV1 {
        return accountRouteV1Service.signUpV1(request)
    }
}
