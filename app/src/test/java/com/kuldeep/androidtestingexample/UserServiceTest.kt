package com.kuldeep.androidtestingexample

import com.kuldeep.androidtestingexample.mock.LOGIN_STATUS
import com.kuldeep.androidtestingexample.mock.UserRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever


class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.INVALID_PASSWORD )
        //whenever(userRepository.loginUser(any(), any())).thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
    }

    @Test
    fun testUserService(){
        val sut = UserService(userRepository)
        val result=sut.loginUser("rohit@gmail.com","123456")

        Assert.assertEquals("Login successful", result)

    }

}