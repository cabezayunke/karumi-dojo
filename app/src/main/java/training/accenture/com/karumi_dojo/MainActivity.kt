package training.accenture.com.karumi_dojo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import training.accenture.com.karumi_dojo.model.AuthService
import training.accenture.com.karumi_dojo.presenter.MainPresenter
import training.accenture.com.karumi_dojo.utils.Clock
import training.accenture.com.karumi_dojo.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    var viewLogin: LinearLayout ?= null
    var viewLogout: LinearLayout ?= null
    var presenter: MainPresenter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewLogin = findViewById(R.id.view_login) as LinearLayout
        viewLogout = findViewById(R.id.view_logout) as LinearLayout

        presenter = MainPresenter(
                AuthService(Clock()),
                this
        )

        initView()
    }

    fun initView() {
        val etUsername = findViewById(R.id.et_username) as EditText
        val etPassword = findViewById(R.id.et_password) as EditText
        val btnLogin = findViewById(R.id.btn_login) as Button
        btnLogin.setOnClickListener {
            presenter?.onLoginBtnClick(etUsername.text.toString(), etPassword.text.toString())
        }
        val btnLogout = findViewById(R.id.btn_logout) as Button
        btnLogout.setOnClickListener {
            presenter?.onLogoutButtonClick()
        }
    }

    /*
     * MainView interface
     */
    override fun onLoginSuccess() {
        Toast.makeText(this@MainActivity, "Welcome", Toast.LENGTH_SHORT).show()
        viewLogin?.setVisibility(View.GONE);
        viewLogout?.setVisibility(View.VISIBLE);
    }

    override fun onLoginError() {
        Toast.makeText(this@MainActivity, "Invalid credentials", Toast.LENGTH_SHORT).show()
    }

    override fun onLogoutSuccess() {
        Toast.makeText(this@MainActivity, "Bye bye", Toast.LENGTH_SHORT).show()
        viewLogin?.setVisibility(View.VISIBLE);
        viewLogout?.setVisibility(View.GONE);
    }

    override fun onLogoutError() {
        Toast.makeText(this@MainActivity, "Error while logging out", Toast.LENGTH_SHORT).show()
    }

}
