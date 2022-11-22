package com.example.restaurant


import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import com.smarteist.autoimageslider.SliderView
import com.tomer.fadingtextview.FadingTextView


class MainActivity : AppCompatActivity() {

    private lateinit var fadingTextView: FadingTextView
    private lateinit var sliderView: SliderView
    lateinit var sliderAdapter: SliderAdapter
    private lateinit var imageList : ArrayList<Int>

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuButton = findViewById<Button>(R.id.Menu) // menu button
        val tableOrder = findViewById<Button>(R.id.OrderTable) // menu button
        sliderView = findViewById(R.id.gallery) // the image gallery

        // adding the images to the slider gallery
        imageList = ArrayList()
        imageList.add(R.drawable.restaurant1)
        imageList.add(R.drawable.restaurant2)
        imageList.add(R.drawable.restaurant3)
        imageList.add(R.drawable.restaurant4)
        imageList.add(R.drawable.restaurant5)

        // initializing our slider adapter and adding our list to it.
        sliderAdapter = SliderAdapter( imageList)

        // setting auto cycle direction for our slider view from left to right.
        sliderView.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_LEFT

        // setting the adapter for the slider
        sliderView.setSliderAdapter(sliderAdapter)

        // setting scroll time in seconds
        sliderView.scrollTimeInSec = 4

        // setting auto cycle to true
        sliderView.isAutoCycle = true

        // calling to start auto cycle to start the cycle
        sliderView.startAutoCycle()


        // fadingTextView text
        val text = this.resources.getStringArray(R.array.words_loop)
        fadingTextView = findViewById(R.id.FadingText)
        fadingTextView.setTexts(text)

        // moving to the menu page
        menuButton.setOnClickListener{
            val intent = Intent(this@MainActivity, MenuActivity::class.java)
            startActivity(intent)
        }

        // moving to the table order page
        tableOrder.setOnClickListener {
            val intent = Intent(this@MainActivity, TableOrderActivity::class.java)
            startActivity(intent)
        }

    }

}