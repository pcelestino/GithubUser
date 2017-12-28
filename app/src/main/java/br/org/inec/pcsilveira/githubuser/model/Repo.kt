package br.org.inec.pcsilveira.githubuser.model

import com.google.gson.annotations.SerializedName

data class Repo(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("description") val description: String,
        @SerializedName("url") val url: String,
        @SerializedName("language") val language: String,
        @SerializedName("created_at") val createdAt: String,
        @SerializedName("updated_at") val updatedAt: String,
        @SerializedName("pushed_at") val pushedAt: String
)