package com.example.restaurant

import com.smarteist.autoimageslider.SliderViewAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class SliderAdapter(imageUrl: ArrayList<Int>) : SliderViewAdapter<SliderAdapter.SliderViewHolder>() {

    var sliderList: ArrayList<Int> = imageUrl


    class SliderViewHolder(itemView: View?) : SliderViewAdapter.ViewHolder(itemView) {
        // variable for our image view, initialized with image id

        var imageView: ImageView = itemView!!.findViewById(R.id.ImageGallery)
    }

    override fun getCount(): Int {
        // returning the size of our list

        return sliderList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?) : SliderAdapter.SliderViewHolder {
        // inflate our layout file for the slider and passing the view to our slider view holder

        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.image_card, parent, false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
        // if the view holder is not null loading the image inside our image view

        viewHolder?.imageView?.setImageResource(sliderList[position])
    }


}