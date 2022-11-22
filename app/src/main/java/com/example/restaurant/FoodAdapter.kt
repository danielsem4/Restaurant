package com.example.restaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val foodList: ArrayList<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // variable for our menu card, initialized with image id name id and description id

        val imageView : ImageView = itemView.findViewById(R.id.foodImage)
        val nameView : TextView = itemView.findViewById(R.id.FoodName)
        val descriptionView : TextView = itemView.findViewById(R.id.FoodDescription)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        // inflate our layout file for the menu and passing the view to our menu view holder

        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_card, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        // loading the image name and description our menu view

        val food = foodList[position]
        holder.imageView.setImageResource(food.image)
        holder.nameView.text = food.name
        holder.descriptionView.text = food.description
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}