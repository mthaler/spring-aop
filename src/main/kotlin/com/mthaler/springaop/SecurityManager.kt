package com.mthaler.springaop

class SecurityManager {

    private val threadLocal = ThreadLocal<UserInfo?>()

    fun login(userName: String, password: String) {
        threadLocal.set(UserInfo(userName, password))
    }

    fun logout() {
        threadLocal.set(null)
    }

    fun getLoggedOnUser(): UserInfo? {
        return threadLocal.get()
    }
}