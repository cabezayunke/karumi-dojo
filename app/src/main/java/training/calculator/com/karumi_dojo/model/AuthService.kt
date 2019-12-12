package training.calculator.com.karumi_dojo.model

import training.calculator.com.karumi_dojo.utils.Clock

class AuthService(val clock: Clock) {
    fun login(username: String, password: String): Boolean = username == "admin" && password == "admin"
    fun logout(): Boolean = clock.now().time % 2 == 0L
}