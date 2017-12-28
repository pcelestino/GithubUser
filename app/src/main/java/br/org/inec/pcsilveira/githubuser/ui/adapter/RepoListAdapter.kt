package br.org.inec.pcsilveira.githubuser.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.org.inec.pcsilveira.githubuser.R
import br.org.inec.pcsilveira.githubuser.extension.formatToBrazilianDate
import br.org.inec.pcsilveira.githubuser.extension.limitsUpTo
import br.org.inec.pcsilveira.githubuser.model.Repo
import kotlinx.android.synthetic.main.github_user_repo.view.*

class RepoListAdapter(private val context: Context,
                      private val repos: List<Repo>) : Adapter<RepoListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.let {
            val repo = repos[position]
            holder.bindView(repo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.github_user_repo, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = repos.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(repo: Repo) {
            val name: TextView = itemView.repoNameTextView
            val description: TextView = itemView.repoDescriptionTextView
            val language: TextView = itemView.repoLanguageTextView
            val createdAt: TextView = itemView.repoCreatedAtTextView

            name.text = repo.name
            description.text = repo.description.limitsUpTo(100)
            language.text = repo.language
            createdAt.text = repo.createdAt.formatToBrazilianDate()
        }
    }
}

