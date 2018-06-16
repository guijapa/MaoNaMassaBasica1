package com.example.guilhermehayashi.maonamassabasico1.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

public interface PokedexService {
    @GET("pokemon/?limit=150")
    fun getPokemons(): Observable<PokemonsResponse>

    @GET("pokemon/{id}/")
    fun getPokemon(@Path("id") id: Int): Observable<Pokemon>
}

open class PokemonsResponse(
        @SerializedName("count")
        @Expose var count: Int,

        @SerializedName("results")
        @Expose var results: List<Pokemon>
)

open class Pokemon(
        @SerializedName("name")
        @Expose var name: String
)