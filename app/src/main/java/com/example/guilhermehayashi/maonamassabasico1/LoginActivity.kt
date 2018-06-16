package com.example.guilhermehayashi.maonamassabasico1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.guilhermehayashi.maonamassabasico1.network.*
import kotlinx.android.synthetic.main.login_activity.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class LoginActivity: AppCompatActivity() {

    object companion {
        var userToken: String = ""
        var user: User? = null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        loginButton.setOnClickListener {
            var email = emailEditText.text.toString()
            var senha = senhaEditText.text.toString()
            var retrofit = RetrofitHelper.getRetrofit(false)
            retrofit?.create(ApiService::class.java)
                    ?.login(LoginRequest(email, senha))
                    ?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribe({
                it?.let {
                    LoginActivity.companion.userToken = it.token
                    LoginActivity.companion.user = it.user
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }, {

            })
        }
    }


}