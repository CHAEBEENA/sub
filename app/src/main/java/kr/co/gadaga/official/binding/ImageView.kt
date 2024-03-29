package kr.co.gadaga.official.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun bindImage(imageView: ImageView, url: String) = Glide.with(imageView.context).load(url).into(imageView)