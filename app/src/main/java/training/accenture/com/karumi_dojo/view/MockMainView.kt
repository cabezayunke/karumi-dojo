package training.accenture.com.karumi_dojo.view

class MockMainView: MainView {
    var loginSuccessCount: Int = 0
    var loginErrorCount: Int = 0
    var logoutSuccessCount: Int = 0
    var logoutErrorCount: Int = 0

    fun reset() {
        loginSuccessCount = 0
        loginErrorCount = 0
        logoutSuccessCount = 0
        logoutErrorCount = 0
    }
    override fun onLoginSuccess() {
        loginSuccessCount++
    }

    override fun onLoginError() {
        loginErrorCount++
    }

    override fun onLogoutSuccess() {
        logoutSuccessCount++
    }

    override fun onLogoutError() {
        logoutErrorCount++
    }
}