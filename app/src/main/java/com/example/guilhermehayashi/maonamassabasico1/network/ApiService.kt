package com.example.guilhermehayashi.maonamassabasico1.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import rx.Observable

public interface ApiService {

    @GET("api/pets")
    fun getPets(): Observable<ApiPetsResponse>

    @POST("api/pets")
    fun savePets(@Body request: Pet)

    @POST("auth/api/v1/login")
    fun login(@Body loginRequest: LoginRequest): Observable<LoginResponse>

}

open class LoginRequest(
        @SerializedName("email")
        @Expose var email: String,

        @SerializedName("password")
        @Expose var password: String
)

open class LoginResponse(
        @SerializedName("token")
        @Expose var token: String,

        @SerializedName("password")
        @Expose var user: User
)

open class User(
        @SerializedName("id")
        @Expose var id: Int,

        @SerializedName("nome")
        @Expose var nome: String,

        @SerializedName("email")
        @Expose var email: String
)

open class ApiPetsResponse(
        @SerializedName("count")
        @Expose var count: Int,

        @SerializedName("results")
        @Expose var results: List<Pet>
)

open class Pet(
        @SerializedName("nome")
        @Expose var nome: String,

        @SerializedName("tipo")
        @Expose var tipoe: String,

        @SerializedName("descricao")
        @Expose var descricao: String,

        @SerializedName("id")
        @Expose var id: Int

)