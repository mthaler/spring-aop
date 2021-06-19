package com.mthaler.springaop

import org.springframework.aop.MethodBeforeAdvice
import java.lang.reflect.Method

class SecurityAdvice(): MethodBeforeAdvice {

    private val securityManager = SecurityManager()

    override fun before(method: Method, args: Array<out Any>, target: Any?) {
        val user = securityManager.getLoggedOnUser()

        if (user == null) {
            println("No user authenticated");
            throw SecurityException("You must login before attempting to invoke the method: ${method.getName()}")
        } else if ("John" == user.userName) {
            println("Logged in user is John - OKAY!")
        } else {
            println("Logged in user is ${user.userName} NOT GOOD :(")
            throw SecurityException("User ${user.userName} is not allowed access to method ${method.getName()}")
        }
    }
}