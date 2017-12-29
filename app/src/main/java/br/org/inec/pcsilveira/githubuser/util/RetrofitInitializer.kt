package br.org.inec.pcsilveira.githubuser.util

import br.org.inec.pcsilveira.githubuser.service.GithubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val githubService: GithubService get() = retrofit.create(GithubService::class.java)
}