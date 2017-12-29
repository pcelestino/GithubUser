package br.org.inec.pcsilveira.githubuser.callback

import br.org.inec.pcsilveira.githubuser.model.User

interface GithubUserReponse {
    fun success(user: User)
    fun failure()
}