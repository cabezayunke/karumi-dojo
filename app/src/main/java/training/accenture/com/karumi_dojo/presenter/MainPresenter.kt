package training.accenture.com.karumi_dojo.presenter

import training.accenture.com.karumi_dojo.model.AuthService
import training.accenture.com.karumi_dojo.view.MainView

class MainPresenter(val service: AuthService, val view: MainView) {

    fun onLoginBtnClick(username: String, password: String) {
        if(service.login(username, password)) {
            view.onLoginSuccess();
        }
        else {
            view.onLoginError();
        }
    }

    fun onLogoutButtonClick() {
        if(service.logout()) {
            view.onLogoutSuccess();
        }
        else {
            view.onLogoutError();
        }
    }
}