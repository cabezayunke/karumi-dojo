package training.accenture.com.karumi_dojo

import org.junit.Test

import org.junit.Assert.*
import training.accenture.com.karumi_dojo.model.AuthService
import training.accenture.com.karumi_dojo.presenter.MainPresenter
import training.accenture.com.karumi_dojo.utils.MockClock
import training.accenture.com.karumi_dojo.view.MockMainView
import java.util.*


class MainPresenterLogoutTest() {

    var mockView = MockMainView()

    @Test
    fun testLogoutSuccess() {
        mockView.reset()
        var clock = MockClock()
        clock.nowOverride = Date(2)
        var presenter = MainPresenter(
                AuthService(clock),
                mockView
        )
        presenter.onLogoutButtonClick()
        assertEquals(mockView.logoutSuccessCount, 1)
        assertEquals(mockView.logoutErrorCount, 0)
    }

    @Test
    fun testLogoutError() {
        mockView.reset()
        var clock = MockClock()
        clock.nowOverride = Date(1)
        var presenter = MainPresenter(
                AuthService(clock),
                mockView
        )
        presenter.onLogoutButtonClick()
        assertEquals(mockView.logoutSuccessCount, 0)
        assertEquals(mockView.logoutErrorCount, 1)
    }
}
