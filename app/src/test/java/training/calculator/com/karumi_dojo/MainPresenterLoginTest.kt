package training.calculator.com.karumi_dojo

import training.calculator.com.karumi_dojo.model.AuthService;
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


import org.junit.Assert.*
import training.calculator.com.karumi_dojo.presenter.MainPresenter
import training.calculator.com.karumi_dojo.utils.MockClock
import training.calculator.com.karumi_dojo.view.MockMainView


@RunWith(Parameterized::class)
class MainPresenterLoginTest(private val username: String, private val password: String, private val successCount: Int, private val errorCount: Int) {

    var mockView = MockMainView()
    val presenter: MainPresenter = MainPresenter(
            AuthService(MockClock()),
            mockView
    )

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf("admin", "admin", 1, 0),
                    arrayOf("admin", "invalid", 0, 1),
                    arrayOf("invalid", "admin", 0, 1),
                    arrayOf("admin", "", 0, 1),
                    arrayOf("", "admin", 0, 1)
            )
        }
    }
    @Test
    fun `MainPresenter verifies correct login`() {
        presenter.onLoginBtnClick(username, password)
        assertEquals(mockView.loginSuccessCount, successCount)
        assertEquals(mockView.loginErrorCount, errorCount)
    }
}
