package training.accenture.com.karumi_dojo

import training.accenture.com.karumi_dojo.AuthService;
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


import org.junit.Assert.*


@RunWith(Parameterized::class)
class AuthServiceLoginTest(private val username: String, private val password: String, private val result: Boolean) {

    val authService: AuthService = AuthService()
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf("admin", "admin", true),
                    arrayOf("admin", "invalid", false),
                    arrayOf("invalid", "admin", false),
                    arrayOf("admin", "", false),
                    arrayOf("", "admin", false)
            )
        }
    }
    @Test
    fun `AuthService verifies correct login`() {
        assertEquals(result, authService.login(username, password))
    }
}
