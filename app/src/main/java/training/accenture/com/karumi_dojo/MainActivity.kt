package training.accenture.com.karumi_dojo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import training.accenture.com.karumi_dojo.AuthService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewLogin = findViewById(R.id.view_login) as LinearLayout
        val viewLogout = findViewById(R.id.view_logout) as LinearLayout

        val btnLogin = findViewById(R.id.btn_login) as Button
        btnLogin.setOnClickListener {
            val result = AuthService().login("user", "pass")
            if(result) {
                Toast.makeText(this@MainActivity, "Welcome", Toast.LENGTH_SHORT).show()
                viewLogin.setVisibility(View.GONE);
                viewLogout.setVisibility(View.VISIBLE);
            }
            else {
                Toast.makeText(this@MainActivity, "Invalid creadentials", Toast.LENGTH_SHORT).show()
            }
        }
        val btnLogout = findViewById(R.id.btn_logout) as Button
        btnLogout.setOnClickListener {
            Toast.makeText(this@MainActivity, "Bye bye", Toast.LENGTH_SHORT).show()
            viewLogin.setVisibility(View.VISIBLE);
            viewLogout.setVisibility(View.GONE);        }
    }

    private fun login(username: String, password: String): Boolean {
        return true
    }
}
