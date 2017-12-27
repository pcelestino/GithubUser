package br.org.inec.pcsilveira.githubuser.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.util.Log
import br.org.inec.pcsilveira.githubuser.R
import br.org.inec.pcsilveira.githubuser.model.User
import br.org.inec.pcsilveira.githubuser.util.RetrofitInitializer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val githubService = RetrofitInitializer().githubService

        github_user_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String) = true
            override fun onQueryTextSubmit(query: String): Boolean {
                Log.d("TEXTO ENVIADO", query)

                githubService.fetchUser(query).enqueue(object : Callback<User> {

                    override fun onResponse(call: Call<User>?, response: Response<User>?) {
                        response?.body()?.let {
                            val user: User = it

                            Log.d("TEXTO MUDOU - RESULTADO", user.toString())
                            Glide.with(this@MainActivity)
                                    .load(user.avatarUrl)
                                    .into(user_image_view)

                            user_name_text_view.text = user.name
                        }
                    }

                    override fun onFailure(call: Call<User>?, t: Throwable?) {
                        Log.d("FALHOU", t.toString())
                        TODO("TRATAR FALHA")
                    }
                })
                return false
            }

        })
    }
}
