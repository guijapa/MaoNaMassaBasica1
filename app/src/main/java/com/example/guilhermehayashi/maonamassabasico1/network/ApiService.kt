package com.example.guilhermehayashi.maonamassabasico1.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import rx.Observable

public interface ApiService {

    @GET("pets")
    fun getPets(): Observable<ApiPetsResponse>

}

open class ApiPetsResponse(
        @SerializedName("count")
        @Expose var count: Int,

        @SerializedName("results")
        @Expose var results: List<Pet>
)

open class Pet(
        @SerializedName("nome")
        @Expose var nome: String,

        @SerializedName("descricao")
        @Expose var descricao: String
)