package com.example.guilhermehayashi.maonamassabasico1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.guilhermehayashi.maonamassabasico1.network.ApiService
import com.example.guilhermehayashi.maonamassabasico1.network.Pet
import com.example.guilhermehayashi.maonamassabasico1.network.PetSaveRequest
import com.example.guilhermehayashi.maonamassabasico1.network.RetrofitHelper
import com.google.gson.Gson
import kotlinx.android.synthetic.main.detalhe_activity.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DetalheActivity: AppCompatActivity() {

    var petId: String = ""
    var pet: Pet? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalhe_activity)
        petId = (intent.extras.get("PET_ID") as Int).toString()
        pet = Gson().fromJson(intent.extras.get("PET") as String, Pet::class.java)
        nomeEditText.setText(pet?.nome)
        descricaoEditText.setText(pet?.descricao)
        updateButton.setOnClickListener {
            var nome = nomeEditText.text.toString()
            var descricao = descricaoEditText.text.toString()
            var pet = PetSaveRequest(dono=LoginActivity.companion.user!!.id.toString(), nome=nome, descricao=descricao)
            var retrofit = RetrofitHelper.getRetrofit(true)
            retrofit?.create(ApiService::class.java)?.updatePet(petId, pet)
                    ?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribe({
                        finish()
                    }, {
                    })
        }
    }
}