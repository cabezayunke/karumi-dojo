package training.accenture.com.karumi_dojo

import org.junit.Test

import org.junit.Assert.*


class AuthServiceLogoutTest() {

    @Test
    fun successfullyLogout() {
        val result = AuthService().logout()
        assertTrue(result)
    }
}
