package com.isaac.randomparrot;

import com.isaac.randomparrot.model.Parrot;
import retrofit2.Call;
import retrofit2.http.GET;

interface ParrotApi {
    @GET("/jmhobbs/cultofthepartyparrot.com/master/parrots.json")
    suspend fun getParrots(): List<Parrot>
}
