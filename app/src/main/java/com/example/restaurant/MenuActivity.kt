package com.example.restaurant


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MenuActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val backIcon = findViewById<ImageButton>(R.id.backIcon) // the back icon
        val menuItems = this.resources.getStringArray(R.array.menuItems) // the menu items

        backIcon.setOnClickListener{
            finish()
        }

        // initial the recyclerView with the data
        foodMenu(menuItems)

    }

    private fun foodMenu(menuItems: Array<String>) {
        recyclerView = findViewById(R.id.menuRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        foodList = ArrayList()
        addDataToList(menuItems)

        foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter
    }

    private fun addDataToList(menuItems: Array<String>) {

        foodList.add(Food(R.drawable.alfredo, menuItems[0], menuItems[1]))
        foodList.add(Food(R.drawable.pizza,menuItems[2], menuItems[3]))
        foodList.add(Food(R.drawable.butter,menuItems[4], menuItems[5]))
        foodList.add(Food(R.drawable.coke, menuItems[6], menuItems[7]))
        foodList.add(Food(R.drawable.water, menuItems[8], menuItems[9]))
        foodList.add(Food(R.drawable.spacielpizza, menuItems[10], menuItems[11]))
        foodList.add(Food(R.drawable.juice, menuItems[12], menuItems[13]))
    }

}