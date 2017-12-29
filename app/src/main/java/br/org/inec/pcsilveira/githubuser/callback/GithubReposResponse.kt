package br.org.inec.pcsilveira.githubuser.callback

import br.org.inec.pcsilveira.githubuser.model.Repo

interface GithubReposResponse {
    fun success(repos: List<Repo>)
    fun failure()
}