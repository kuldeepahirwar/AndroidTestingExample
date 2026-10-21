package com.kuldeep.androidtestingexample

import com.kuldeep.androidtestingexample.mock.LOGIN_STATUS
import com.kuldeep.androidtestingexample.mock.UserRepository

class UserService(private val userRepository: UserRepository) {

    fun loginUser(email: String, password: String): String {
        val status = userRepository.loginUser(email, password)
        return when (status) {
            LOGIN_STATUS.INVALID_USER -> "Invalid user"
            LOGIN_STATUS.INVALID_PASSWORD -> "Invalid password"
            LOGIN_STATUS.SUCCESS -> "Login successful"
            else -> "Unknown error"
        }
 }

}