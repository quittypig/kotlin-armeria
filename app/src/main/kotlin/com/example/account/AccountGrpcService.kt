package com.example.account

import io.grpc.Status
import io.grpc.StatusException
import com.example.account.v1.AccountRouteV1GrpcKt
import com.example.account.v1.SignUpRequestV1
import com.example.account.v1.SignUpResponseV1
import mu.KotlinLogging

private val logger = KotlinLogging.logger { }

class AccountGrpcService : AccountRouteV1GrpcKt.AccountRouteV1CoroutineImplBase() {
    override suspend fun signUpV1(request: SignUpRequestV1): SignUpResponseV1 = try {
        AccountService.signUp(request.toEntity()).toProto()
    } catch (e: Exception) {
        logger.error { e.stackTraceToString() }
        throw StatusException(Status.UNKNOWN.withDescription(e.stackTraceToString()))
    }
}
