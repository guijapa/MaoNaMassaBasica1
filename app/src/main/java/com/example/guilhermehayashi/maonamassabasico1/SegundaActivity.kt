package com.example.guilhermehayashi.maonamassabasico1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_segunda.*

class SegundaActivity : AppCompatActivity() {

    var nome: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        nome = intent.getStringExtra(MainActivity.companion.nameKey)
        editNome.setHint("${nome}, qual seu verdadeiro nome?")
        botaoOk.setOnClickListener({
            /*
            *
            * Passando dados entre activities
            *
            * */
            var intent = Intent()
            intent.putExtra(MainActivity.companion.nameKey, editNome.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        })
    }

}
