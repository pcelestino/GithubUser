package br.org.inec.pcsilveira.githubuser.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import br.org.inec.pcsilveira.githubuser.callback.GlideResponse
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

class GlideLoader {
    fun load(context: Context, url: String, imageView: ImageView, glideResponse: GlideResponse) {
        val radius = 30
        Glide.with(context)
                .load(url)
                .apply(RequestOptions().transform(RoundedCorners(radius)))
                .transition(DrawableTransitionOptions.withCrossFade())
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?,
                                              model: Any?,
                                              target: Target<Drawable>?,
                                              isFirstResource: Boolean): Boolean {
                        glideResponse.failure()
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?,
                                                 model: Any?,
                                                 target: Target<Drawable>?,
                                                 dataSource: DataSource?,
                                                 isFirstResource: Boolean): Boolean {
                        glideResponse.success()
                        return false
                    }

                })
                .into(imageView)
    }
}