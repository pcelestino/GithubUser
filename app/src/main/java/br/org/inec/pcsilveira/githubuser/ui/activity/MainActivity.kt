package br.org.inec.pcsilveira.githubuser.ui.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.view.View
import android.view.animation.AnimationUtils
import br.org.inec.pcsilveira.githubuser.R
import br.org.inec.pcsilveira.githubuser.model.Repo
import br.org.inec.pcsilveira.githubuser.model.User
import br.org.inec.pcsilveira.githubuser.service.GithubService
import br.org.inec.pcsilveira.githubuser.ui.adapter.RepoListAdapter
import br.org.inec.pcsilveira.githubuser.util.RetrofitInitializer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureViewSwitcher()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)

        val searchView = configureSearchView(menu)
        val githubService = RetrofitInitializer().githubService
        handleQuery(searchView, githubService)

        return super.onCreateOptionsMenu(menu)
    }

    private fun handleQuery(searchView: SearchView, githubService: GithubService) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                resetLayout(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                Log.d("TEXTO ENVIADO", query)
                displayUserInfo()

                userInfoProgressBar.visibility = View.VISIBLE

                githubService.fetchUser(query).enqueue(object : Callback<User> {
                    override fun onResponse(call: Call<User>?, response: Response<User>?) {

                        response?.body()?.let {
                            val user: User = it

                            Log.d("TEXTO MUDOU - RESULTADO", user.toString())
                            Glide.with(this@MainActivity)
                                    .load(user.avatarUrl)
                                    .transition(DrawableTransitionOptions.withCrossFade())
                                    .listener(object : RequestListener<Drawable> {
                                        override fun onLoadFailed(e: GlideException?,
                                                                  model: Any?,
                                                                  target: Target<Drawable>?,
                                                                  isFirstResource: Boolean): Boolean {
                                            userInfoProgressBar.visibility = View.GONE
                                            return false
                                        }

                                        override fun onResourceReady(resource: Drawable?,
                                                                     model: Any?,
                                                                     target: Target<Drawable>?,
                                                                     dataSource: DataSource?,
                                                                     isFirstResource: Boolean): Boolean {
                                            userNameTextView.text = user.name
                                            userNickNameTextView.text = user.login
                                            userInfoProgressBar.visibility = View.GONE

                                            userRepoProgressBar.visibility = View.VISIBLE

                                            githubService.listRepos(user.login).enqueue(object : Callback<List<Repo>> {
                                                override fun onResponse(call: Call<List<Repo>>?, response: Response<List<Repo>>?) {
                                                    response?.body()?.let {
                                                        userRepoProgressBar.visibility = View.GONE
                                                        val repos: List<Repo> = it
                                                        with(userReposRecyclerView) {
                                                            layoutManager = LinearLayoutManager(this@MainActivity)
                                                            hasFixedSize()
                                                            adapter = RepoListAdapter(this@MainActivity, repos)
                                                        }
                                                        Log.d("REPOS:", repos.toString())
                                                    }
                                                }

                                                override fun onFailure(call: Call<List<Repo>>?, t: Throwable?) {
                                                    Log.d("FALHOU", t.toString())
                                                }
                                            })
                                            return false
                                        }

                                    })
                                    .into(userImageView)
                        }
                    }

                    override fun onFailure(call: Call<User>?, t: Throwable?) {
                        Log.d("FALHOU", t.toString())
                    }
                })
                return false
            }

        })
    }

    private fun resetLayout(newText: String) {
        if (newText.isEmpty()) {
            userImageView.setImageDrawable(null)
            userNameTextView.text = ""
            userNickNameTextView.text = ""
            userReposRecyclerView.adapter = null
            displayGithubLogo()
        }
    }

    private fun configureSearchView(menu: Menu?): SearchView {
        val searchItem = menu!!.findItem(R.id.github_user_search)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = getString(R.string.github_user_search_hint)
        return searchView
    }

    private fun configureViewSwitcher() {
        val fadeInAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        val fadeOutAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_out)
        githubViewSwitcher.inAnimation = fadeInAnimation
        githubViewSwitcher.outAnimation = fadeOutAnimation
    }

    private fun displayGithubLogo() {
        if (githubViewSwitcher.displayedChild != 0) {
            githubViewSwitcher.displayedChild = 0
        }
    }

    private fun displayUserInfo() {
        if (githubViewSwitcher.displayedChild != 1) {
            githubViewSwitcher.displayedChild = 1
        }
    }
}
