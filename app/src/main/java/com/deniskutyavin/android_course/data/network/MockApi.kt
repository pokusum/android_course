package com.deniskutyavin.android_course.data.network

import com.deniskutyavin.android_course.data.network.Api
import com.deniskutyavin.android_course.data.network.request.CreateProfileRequest
import com.deniskutyavin.android_course.data.network.request.RefreshAuthTokensRequest
import com.deniskutyavin.android_course.data.network.request.SignInWithEmailRequest
import com.deniskutyavin.android_course.entity.AuthTokens
import com.haroldadmin.cnradapter.NetworkResponse
import com.deniskutyavin.android_course.data.network.response.VerificationTokenResponse
import com.deniskutyavin.android_course.data.network.response.error.*
import com.deniskutyavin.android_course.entity.User

class MockApi : Api {
    override suspend fun getUsers(): NetworkResponse<List<User>, GetUsersErrorResponce> {
        return NetworkResponse.Success(
            body = listOf(
                User(
                    userName = "Teacher",
                    avatarUrl = "https://www.quotemaster.org/images/ff/ffb293f7662f49abf11381ad63211040.jpg",
                    groupName = "Best of the best"
                ),
                User(
                    userName = "Student1",
                    avatarUrl = "https://i1.wp.com/supportingeducation.org/wp-content/uploads/2015/08/studnetsss.jpg?resize=1000%2C667&ssl=1",
                    groupName = "?"
                )
            ),
            code = 200
        )
    }

    override suspend fun signInWithEmail(request: SignInWithEmailRequest): NetworkResponse<AuthTokens, SignInWithEmailErrorResponse> {
        return NetworkResponse.Success(
            AuthTokens(
                accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI",
                refreshToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI",
                accessTokenExpiration = 1640871771000,
                refreshTokenExpiration = 1640871771000,
            ),
            code = 200
        )
    }

    override suspend fun refreshAuthTokens(request: RefreshAuthTokensRequest): NetworkResponse<AuthTokens, RefreshAuthTokensErrorResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun sendRegistrationVerificationCode(email: String): NetworkResponse<Unit, SendRegistrationVerificationCodeErrorResponse> {
        return NetworkResponse.Success(
            body = Unit,
            code = 200
        )
    }

    override suspend fun verifyRegistrationCode(
        code: String,
        email: String?
    ): NetworkResponse<VerificationTokenResponse, VerifyRegistrationCodeErrorResponse> {
        return NetworkResponse.Success(
            body = VerificationTokenResponse("OK"),
            code = 200
        )
    }

    override suspend fun createProfile(request: CreateProfileRequest): NetworkResponse<AuthTokens, CreateProfileErrorResponse> {
        return NetworkResponse.Success(
            AuthTokens(
                accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI",
                refreshToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI",
                accessTokenExpiration = 1640871771000,
                refreshTokenExpiration = 1640871771000,
            ),
            code = 200
        )
    }
}