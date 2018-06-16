package com.example.guilhermehayashi.maonamassabasico1.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

public interface PokedexService {
    @GET("pokemon/{id}/")
    fun getPokemon(@Path("id") id: Int): Observable<PokemonResponse>
}

open class PokemonRequest(
    @SerializedName("id")
    @Expose var id: String
)

open class PokemonResponse(
        @SerializedName("name")
        @Expose var name: String
)