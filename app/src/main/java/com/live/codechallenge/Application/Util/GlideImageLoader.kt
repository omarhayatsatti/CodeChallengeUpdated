package com.live.codechallenge.Application.Util

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class GlideImageLoader {
    companion object {
        fun LoadImage(cx: Context?, imageView: ImageView, demoImage: Int, url: String) {
            if (!(cx as Activity).isFinishing) {
                Glide.with(cx).clear(imageView)
                if (url != null && !url.equals("") && !url.equals("null")) {
                    var patnFinal = url!!.replace("\\", "/")
                    var requestOptions = RequestOptions()
                    requestOptions = requestOptions.transforms(RoundedCorners(20))
                        //.placeholder(demoImage)
                        //.override(733,318)
                        //.diskCacheStrategy(DiskCacheStrategy.NONE)
                        //.skipMemoryCache(true)
                    Glide.with(cx)
                        .load(patnFinal).apply(requestOptions)
                        .thumbnail(Glide.with(cx).load(demoImage)).into(imageView)
                } else {
                    var requestOptions = RequestOptions()
                    requestOptions = requestOptions.transforms(RoundedCorners(20))
                        .placeholder(demoImage)
                        //.override(733,318)
                        //.diskCacheStrategy(DiskCacheStrategy.NONE)
                        //.skipMemoryCache(true)
                    Glide.with(cx)
                        .load(url).apply(requestOptions)
                        .into(imageView)
                }
            }
        }
    }

}