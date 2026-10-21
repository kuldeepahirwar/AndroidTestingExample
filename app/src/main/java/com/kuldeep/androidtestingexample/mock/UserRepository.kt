package com.kuldeep.androidtestingexample.mock

class UserRepository {
    val users = listOf<User>(
        User(1, "John Doe", "johan@gmail.com", "123456"),
        User(2, "Suman Kumar", "suman@gmail.com", "123456"),
        User(3, "Rohit Kumar", "rohit@gmail.com", "123456"),
    )

    fun loginUser(email: String, password: String): LOGIN_STATUS {
        val user = users.find { it.email == email }
        return if (user == null) {
            LOGIN_STATUS.INVALID_USER
        } else if (user.password != password) {
            LOGIN_STATUS.INVALID_PASSWORD
        } else {
            LOGIN_STATUS.SUCCESS
        }
    }
}