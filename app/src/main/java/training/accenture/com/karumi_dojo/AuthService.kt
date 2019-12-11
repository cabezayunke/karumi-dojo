package training.accenture.com.karumi_dojo

class AuthService {
    fun login(username: String, password: String): Boolean = username == "admin" && password == "admin"
    fun logout(): Boolean = (System.currentTimeMillis() / 1000) % 2 == 0L
}