package com.example.guilhermehayashi.maonamassabasico1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.guilhermehayashi.maonamassabasico1.network.*
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val senha = senhaEditText.text.toString()
            Api.login(email, senha, {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            })
        }
    }

}