package com.mthaler.springaop

object SecurityManager {

    private var userInfo: UserInfo? = null

    fun login(userName: String, password: String) {
        userInfo = UserInfo(userName, password)
    }

    fun logout() {
        userInfo = null
    }

    fun getLoggedOnUser(): UserInfo? {
        return userInfo
    }
}