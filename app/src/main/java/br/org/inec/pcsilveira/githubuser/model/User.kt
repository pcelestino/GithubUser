package br.org.inec.pcsilveira.githubuser.model

import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("login") val login: String, //pcelestino
        @SerializedName("id") val id: Int, //4588836
        @SerializedName("avatar_url") val avatarUrl: String, //https://avatars1.githubusercontent.com/u/4588836?v=4
        @SerializedName("gravatar_id") val gravatarId: String,
        @SerializedName("url") val url: String, //https://api.github.com/users/pcelestino
        @SerializedName("html_url") val htmlUrl: String, //https://github.com/pcelestino
        @SerializedName("followers_url") val followersUrl: String, //https://api.github.com/users/pcelestino/followers
        @SerializedName("following_url") val followingUrl: String, //https://api.github.com/users/pcelestino/following{/other_user}
        @SerializedName("gists_url") val gistsUrl: String, //https://api.github.com/users/pcelestino/gists{/gist_id}
        @SerializedName("starred_url") val starredUrl: String, //https://api.github.com/users/pcelestino/starred{/owner}{/repo}
        @SerializedName("subscriptions_url") val subscriptionsUrl: String, //https://api.github.com/users/pcelestino/subscriptions
        @SerializedName("organizations_url") val organizationsUrl: String, //https://api.github.com/users/pcelestino/orgs
        @SerializedName("repos_url") val reposUrl: String, //https://api.github.com/users/pcelestino/repos
        @SerializedName("events_url") val eventsUrl: String, //https://api.github.com/users/pcelestino/events{/privacy}
        @SerializedName("received_events_url") val receivedEventsUrl: String, //https://api.github.com/users/pcelestino/received_events
        @SerializedName("type") val type: String, //User
        @SerializedName("site_admin") val siteAdmin: Boolean, //false
        @SerializedName("name") val name: String, //Pedro Celestino
        @SerializedName("company") val company: String, //null
        @SerializedName("blog") val blog: String,
        @SerializedName("location") val location: String, //null
        @SerializedName("email") val email: String, //null
        @SerializedName("hireable") val hireable: Boolean, //null
        @SerializedName("bio") val bio: String, //null
        @SerializedName("public_repos") val publicRepos: Int, //22
        @SerializedName("public_gists") val publicGists: Int, //0
        @SerializedName("followers") val followers: Int, //5
        @SerializedName("following") val following: Int, //0
        @SerializedName("created_at") val createdAt: String, //2013-06-01T18:05:23Z
        @SerializedName("updated_at") val updatedAt: String //2017-12-22T09:21:09Z
)