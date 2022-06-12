package com.sajjad.weatherapp.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.sajjad.weatherapp.getFormattedDate
import com.sajjad.weatherapp.icon_prefix
import com.sajjad.weatherapp.icon_suffix

@BindingAdapter("app:setWeatherIcon")
fun setIcon(imageView: ImageView, icon: String?) {
    icon?.let {
        val url = "$icon_prefix$icon$icon_suffix"
        Glide
            .with(imageView.context)
            .load(url)
            .into(imageView)
    }

}
@BindingAdapter("app:setDateTime")
fun setDateTime(textView: TextView,dt :Long){
    textView.text = getFormattedDate(dt,"MMM dd, yyyy hh:mm a")
}
@BindingAdapter("app:setWeekdayTime")
fun setWeekdayTime(textView: TextView,dt :Long){
    textView.text = getFormattedDate(dt,"EEE, hh:mm a")
}

@BindingAdapter("app:setTime")
fun setTime(textView: TextView,dt :Long){
    textView.text = getFormattedDate(dt,"hh:mm a")
}