package br.org.inec.pcsilveira.githubuser.service

import br.org.inec.pcsilveira.githubuser.model.Repo
import br.org.inec.pcsilveira.githubuser.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/{user}")
    fun fetchUser(@Path("user") user: String): Call<User>

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repo>>
}