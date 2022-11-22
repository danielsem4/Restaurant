package com.example.restaurant

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import java.lang.Thread.sleep
import java.text.SimpleDateFormat
import java.util.*

class TableOrderActivity : AppCompatActivity() {

    private var chosenDate = ""
    private var chosenTime = ""
    private var amountOfSits = 0
    private var veganMenu = "Regular menu is selected"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_book)

        val monkeyPic = findViewById<ImageButton>(R.id.monkeyPic) // the image button
        val dateBtn = findViewById<Button>(R.id.date) // date picker button in order page
        val backIcon = findViewById<ImageButton>(R.id.backIcon) // back icon to the main activity
        val timeBtn = findViewById<Button>(R.id.Clock) // time picker button in order page
        val addBtn = findViewById<Button>(R.id.plusOne) // the add sit button
        val subBtn = findViewById<Button>(R.id.minusOne) // the sub sit button
        val amountOfSitsTxt = findViewById<TextView>(R.id.amountOfSits) // the amount of sits
        val veganMenuToggle = findViewById<SwitchCompat>(R.id.VeganMenuSwitch) // the vegan menu toggle
        val submitButton = findViewById<Button>(R.id.submitOrder) // submit button

        val toastInfo = this.resources.getStringArray(R.array.toastInfo)
        val orderDetailsInfo = this.resources.getStringArray(R.array.orderDetailsInfo)


        // back icon action
        backIcon.setOnClickListener{
            finish()
        }

        val rotateAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate)
        monkeyPic.startAnimation(rotateAnim)

        // choose date, open date dialog
        dateBtn.setOnClickListener {
            val calendar = Calendar.getInstance()
            val listener = DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                chosenDate = "${orderDetailsInfo[3]} $i3 / $i2 / $i"
                Toast.makeText(this, chosenDate, Toast.LENGTH_SHORT).show()
                datePicker.minDate
            }
            val dtb = DatePickerDialog(
                this,
                listener,
                calendar.get(Calendar.YEAR),
                calendar.get(
                    Calendar.MONTH
                ),
                calendar.get(Calendar.DAY_OF_MONTH)
            )

            dtb.datePicker.minDate = System.currentTimeMillis() - 1000

            dtb.show()
        }

        // choose time, open time dialog
        timeBtn.setOnClickListener {
            val currTime = Calendar.getInstance()
            val listener = TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                chosenTime = "${orderDetailsInfo[4]} $i : $i2"
                Toast.makeText(this, chosenTime, Toast.LENGTH_SHORT).show()
            }
            val ttb = TimePickerDialog(
                this,
                listener,
                currTime.get(Calendar.HOUR_OF_DAY),
                currTime.get(Calendar.MINUTE),
                false
            )
            ttb.show()
        }

        // add amount of sits
        addBtn.setOnClickListener {
            if (amountOfSits < 30) {
                amountOfSits += 1
                amountOfSitsTxt.text = amountOfSits.toString()
            } else {
                Toast.makeText(this, toastInfo[0], Toast.LENGTH_SHORT).show()
            }

        }

        // sub amount of sits
        subBtn.setOnClickListener {
            if(amountOfSits > 0) {
                amountOfSits -= 1
                amountOfSitsTxt.text = amountOfSits.toString()
            } else {
                Toast.makeText(this, toastInfo[1], Toast.LENGTH_SHORT).show()
            }
        }

        veganMenuToggle.setOnCheckedChangeListener { compoundButton, b ->
            veganMenu = if(b) {
                orderDetailsInfo[5]
            } else {
                orderDetailsInfo[6]
            }
        }

        // submit order dialog
        submitButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.order_submit_dialog, null)

            builder.setView(dialogView)
            val dialog = builder.create()
            if (chosenDate != "" && chosenTime != "" && amountOfSits > 0) {
                dialog.setTitle(orderDetailsInfo[0])
                dialog.setMessage("\n$chosenDate\n$chosenTime\n${orderDetailsInfo[7]} $amountOfSits\n$veganMenu")

                dialogView.findViewById<Button>(R.id.Submit).setOnClickListener {
                    Toast.makeText(this, toastInfo[2], Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                    sleep(1500)
                    finish()
                }
            } else {
                dialog.setTitle(orderDetailsInfo[1])
                dialog.setMessage(orderDetailsInfo[2])
                dialogView.findViewById<Button>(R.id.Submit).setOnClickListener {
                    Toast.makeText(this, toastInfo[3], Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }

            dialog.show()
        }
    }

}