package br.org.inec.pcsilveira.githubuser.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import br.org.inec.pcsilveira.githubuser.R
import br.org.inec.pcsilveira.githubuser.callback.GithubReposResponse
import br.org.inec.pcsilveira.githubuser.callback.GithubUserReponse
import br.org.inec.pcsilveira.githubuser.callback.GlideResponse
import br.org.inec.pcsilveira.githubuser.model.Repo
import br.org.inec.pcsilveira.githubuser.model.User
import br.org.inec.pcsilveira.githubuser.service.GithubWebClient
import br.org.inec.pcsilveira.githubuser.ui.adapter.RepoListAdapter
import br.org.inec.pcsilveira.githubuser.util.GlideLoader
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val githubWebClient = GithubWebClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureViewSwitcher()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)

        val searchView = configureSearchView(menu)
        handleQuery(searchView)

        return super.onCreateOptionsMenu(menu)
    }

    private fun handleQuery(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    resetLayout()
                }
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                resetLayout()
                displayUserInfo()
                showUserInfoProgressBar()
                fetchUser(query)
                return false
            }

        })
    }

    private fun fetchUser(query: String) {
        githubWebClient.fetchUser(query, object : GithubUserReponse {
            override fun success(user: User) {
                configureUserInfo(user)
            }

            override fun failure() {
                hideUserInfoProgressBar()
                showError(getString(R.string.invalid_user))
                displayGithubLogo()
            }
        })
    }

    private fun configureUserInfo(user: User) {
        GlideLoader().load(this, user.avatarUrl, userImageView, object : GlideResponse {
            override fun success() {
                hideUserInfoProgressBar()
                showUserReposProgressBar()

                userNameTextView.text = user.name
                userNickNameTextView.text = user.login

                loadListRepos(user)
            }

            override fun failure() {
                hideUserInfoProgressBar()
            }

        })
    }

    private fun loadListRepos(user: User) {
        githubWebClient.listRepos(user.login, object : GithubReposResponse {
            override fun success(repos: List<Repo>) {
                hideUserReposProgressBar()
                configureUserReposList(repos)
            }

            override fun failure() {
                hideUserReposProgressBar()
                showError(getString(R.string.invalid_repository))
                displayGithubLogo()
            }
        })
    }

    private fun configureUserReposList(repos: List<Repo>) {
        with(userReposRecyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()
            adapter = RepoListAdapter(this@MainActivity, repos)
        }
    }

    private fun resetLayout() {
        userImageView.setImageDrawable(null)
        userNameTextView.text = ""
        userNickNameTextView.text = ""
        userReposRecyclerView.adapter = null
        displayGithubLogo()
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

    private fun hideUserInfoProgressBar() {
        userInfoProgressBar.visibility = View.GONE
    }

    private fun showUserInfoProgressBar() {
        userInfoProgressBar.visibility = View.VISIBLE
    }

    private fun hideUserReposProgressBar() {
        userReposProgressBar.visibility = View.GONE
    }

    private fun showUserReposProgressBar() {
        userReposProgressBar.visibility = View.VISIBLE
    }

    private fun showError(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
    }
}
