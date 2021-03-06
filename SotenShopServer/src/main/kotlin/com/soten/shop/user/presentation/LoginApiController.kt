package com.soten.shop.user.presentation

import com.soten.shop.common.ApiResponse
import com.soten.shop.auth.interceptor.JwtUtil
import com.soten.shop.auth.interceptor.LoginRequest
import com.soten.shop.auth.interceptor.SignInService
import com.soten.shop.auth.interceptor.UserContextHolder
import com.soten.shop.auth.interceptor.TokenValidationInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.IllegalArgumentException

@RestController
@RequestMapping("/soten")
class LoginApiController @Autowired constructor(
    private val signInService: SignInService,
    private val userContextHolder: UserContextHolder
) {

    @PostMapping("/sign-in")
    fun signIn(@RequestBody loginRequest: LoginRequest) =
        ApiResponse.ok(signInService.signIn(loginRequest))

    @PostMapping("/refresh_token")
    fun refreshToken(
        @RequestParam("grant_type") grantType: String
    ): ApiResponse {
        if (grantType != TokenValidationInterceptor.GRANT_TYPE_REFRESH) {
            throw IllegalArgumentException("grant_type 없음")
        }

        return userContextHolder.email?.let {
            ApiResponse.ok(JwtUtil.createToken(it))
        } ?: throw IllegalArgumentException("사용자 정보 없음")
    }

}
