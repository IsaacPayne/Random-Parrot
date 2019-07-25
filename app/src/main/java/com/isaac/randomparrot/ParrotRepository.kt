package com.isaac.randomparrot

class ParrotRepository {

    private var client: ParrotApi = RetrofitClient.webservice

    suspend fun getParrots() = client.getParrots()
}