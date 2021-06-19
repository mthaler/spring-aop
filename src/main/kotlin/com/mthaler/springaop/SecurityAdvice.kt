package com.mthaler.springaop

import org.springframework.aop.MethodBeforeAdvice
import java.lang.reflect.Method

class SecurityAdvice(val securityManager: SecurityManager): MethodBeforeAdvice {

    override fun before(method: Method, args: Array<out Any>, target: Any?) {
        val user = securityManager.getLoggedOnUser()

        if (user == null) {
            System.out.println("No user authenticated");
            throw SecurityException("You must login before attempting to invoke the method: ${method.getName()}")
        } else if ("John" == user.userName) {
            System.out.println("Logged in user is John - OKAY!")
        } else {
            System.out.println("Logged in user is ${user.userName} NOT GOOD :(")
            throw SecurityException("User ${user.userName} is not allowed access to method ${method.getName()}")
        }
    }
}