package br.org.inec.pcsilveira.githubuser.service

import android.util.Log
import br.org.inec.pcsilveira.githubuser.callback.GithubReposResponse
import br.org.inec.pcsilveira.githubuser.callback.GithubUserReponse
import br.org.inec.pcsilveira.githubuser.model.Repo
import br.org.inec.pcsilveira.githubuser.model.User
import br.org.inec.pcsilveira.githubuser.util.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubWebClient {
    private val githubService = RetrofitInitializer().githubService

    fun fetchUser(userQuery: String, githubUserReponse: GithubUserReponse) {
        githubService.fetchUser(userQuery).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                response?.code()?.let {
                    if (it == 200) {
                        response.body()?.let {
                            val user: User = it
                            githubUserReponse.success(user)
                        }
                    } else {
                        githubUserReponse.failure()
                    }
                }
            }

            override fun onFailure(call: Call<User>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

    fun listRepos(user: String, githubReposResponse: GithubReposResponse) {
        githubService.listRepos(user).enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>?, response: Response<List<Repo>>?) {
                response?.code().let {
                    if (it == 200) {
                        response?.body()?.let {
                            val repos: List<Repo> = it
                            githubReposResponse.success(repos)
                        }
                    } else {
                        githubReposResponse.failure()
                    }
                }
            }

            override fun onFailure(call: Call<List<Repo>>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }
}