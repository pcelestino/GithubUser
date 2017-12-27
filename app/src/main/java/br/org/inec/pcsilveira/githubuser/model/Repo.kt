package br.org.inec.pcsilveira.githubuser.model

import com.google.gson.annotations.SerializedName

data class Repo(
        @SerializedName("id") val id: Int, //58879572
        @SerializedName("name") val name: String, //AndroidDesignPattern
        @SerializedName("full_name") val fullName: String, //pcelestino/AndroidDesignPattern
        @SerializedName("owner") val owner: Owner,
        @SerializedName("private") val private: Boolean, //false
        @SerializedName("html_url") val htmlUrl: String, //https://github.com/pcelestino/AndroidDesignPattern
        @SerializedName("description") val description: String, //Projeto simples de cadastro de vendas utilizando os padrões Strategy, Chain Of Responsibility, Template Method, Build e Observer
        @SerializedName("fork") val fork: Boolean, //false
        @SerializedName("url") val url: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern
        @SerializedName("forks_url") val forksUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/forks
        @SerializedName("keys_url") val keysUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/keys{/key_id}
        @SerializedName("collaborators_url") val collaboratorsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/collaborators{/collaborator}
        @SerializedName("teams_url") val teamsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/teams
        @SerializedName("hooks_url") val hooksUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/hooks
        @SerializedName("issue_events_url") val issueEventsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/issues/events{/number}
        @SerializedName("events_url") val eventsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/events
        @SerializedName("assignees_url") val assigneesUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/assignees{/user}
        @SerializedName("branches_url") val branchesUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/branches{/branch}
        @SerializedName("tags_url") val tagsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/tags
        @SerializedName("blobs_url") val blobsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/git/blobs{/sha}
        @SerializedName("git_tags_url") val gitTagsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/git/tags{/sha}
        @SerializedName("git_refs_url") val gitRefsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/git/refs{/sha}
        @SerializedName("trees_url") val treesUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/git/trees{/sha}
        @SerializedName("statuses_url") val statusesUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/statuses/{sha}
        @SerializedName("languages_url") val languagesUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/languages
        @SerializedName("stargazers_url") val stargazersUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/stargazers
        @SerializedName("contributors_url") val contributorsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/contributors
        @SerializedName("subscribers_url") val subscribersUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/subscribers
        @SerializedName("subscription_url") val subscriptionUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/subscription
        @SerializedName("commits_url") val commitsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/commits{/sha}
        @SerializedName("git_commits_url") val gitCommitsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/git/commits{/sha}
        @SerializedName("comments_url") val commentsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/comments{/number}
        @SerializedName("issue_comment_url") val issueCommentUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/issues/comments{/number}
        @SerializedName("contents_url") val contentsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/contents/{+path}
        @SerializedName("compare_url") val compareUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/compare/{base}...{head}
        @SerializedName("merges_url") val mergesUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/merges
        @SerializedName("archive_url") val archiveUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/{archive_format}{/ref}
        @SerializedName("downloads_url") val downloadsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/downloads
        @SerializedName("issues_url") val issuesUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/issues{/number}
        @SerializedName("pulls_url") val pullsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/pulls{/number}
        @SerializedName("milestones_url") val milestonesUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/milestones{/number}
        @SerializedName("notifications_url") val notificationsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/notifications{?since,all,participating}
        @SerializedName("labels_url") val labelsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/labels{/name}
        @SerializedName("releases_url") val releasesUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/releases{/id}
        @SerializedName("deployments_url") val deploymentsUrl: String, //https://api.github.com/repos/pcelestino/AndroidDesignPattern/deployments
        @SerializedName("created_at") val createdAt: String, //2016-05-15T19:16:25Z
        @SerializedName("updated_at") val updatedAt: String, //2016-05-15T19:18:53Z
        @SerializedName("pushed_at") val pushedAt: String, //2016-05-15T20:28:46Z
        @SerializedName("git_url") val gitUrl: String, //git://github.com/pcelestino/AndroidDesignPattern.git
        @SerializedName("ssh_url") val sshUrl: String, //git@github.com:pcelestino/AndroidDesignPattern.git
        @SerializedName("clone_url") val cloneUrl: String, //https://github.com/pcelestino/AndroidDesignPattern.git
        @SerializedName("svn_url") val svnUrl: String, //https://github.com/pcelestino/AndroidDesignPattern
        @SerializedName("homepage") val homepage: String, //null
        @SerializedName("size") val size: Int, //112
        @SerializedName("stargazers_count") val stargazersCount: Int, //0
        @SerializedName("watchers_count") val watchersCount: Int, //0
        @SerializedName("language") val language: String, //Java
        @SerializedName("has_issues") val hasIssues: Boolean, //true
        @SerializedName("has_projects") val hasProjects: Boolean, //true
        @SerializedName("has_downloads") val hasDownloads: Boolean, //true
        @SerializedName("has_wiki") val hasWiki: Boolean, //true
        @SerializedName("has_pages") val hasPages: Boolean, //false
        @SerializedName("forks_count") val forksCount: Int, //0
        @SerializedName("mirror_url") val mirrorUrl: String, //null
        @SerializedName("archived") val archived: Boolean, //false
        @SerializedName("open_issues_count") val openIssuesCount: Int, //0
        @SerializedName("license") val license: String, //null
        @SerializedName("forks") val forks: Int, //0
        @SerializedName("open_issues") val openIssues: Int, //0
        @SerializedName("watchers") val watchers: Int, //0
        @SerializedName("default_branch") val defaultBranch: String //master
)