package com.mthaler.springaop

import org.springframework.aop.framework.ProxyFactory

fun main(args: Array<String>) {

    val bean = getSecureBean()

    SecurityManager.login("John", "pwd")
    bean.writeSecureMessage()
    SecurityManager.logout()

    try {
        SecurityManager.login("invalid user", "pwd")
        bean.writeSecureMessage()
    } catch (ex: SecurityException) {
        println("Exception Caught: " + ex.message)
    } finally {
        SecurityManager.logout()
    }

    try {
        bean.writeSecureMessage()
    } catch (ex: SecurityException) {
        println("Exception Caught: " + ex.message)
    }
}

private fun getSecureBean(): SecureBean {
    val target = SecureBean()
    val advice = SecurityAdvice()
    val factory = ProxyFactory()
    factory.setTarget(target)
    factory.addAdvice(advice)
    return factory.proxy as SecureBean
}