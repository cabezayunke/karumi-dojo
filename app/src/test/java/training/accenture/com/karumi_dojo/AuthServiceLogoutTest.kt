package training.accenture.com.karumi_dojo

import org.junit.Test

import org.junit.Assert.*
import training.accenture.com.karumi_dojo.model.AuthService
import training.accenture.com.karumi_dojo.utils.MockClock
import java.util.*


class AuthServiceLogoutTest() {

    @Test
    fun testLogoutSuccess() {
        var clock = MockClock()
        clock.nowOverride = Date(2)
        val result = AuthService(clock).logout()
        assertTrue(result)
    }
    @Test
    fun testLogoutError() {
        val result = AuthService(MockClock()).logout()
        assertFalse(result)
    }
}
