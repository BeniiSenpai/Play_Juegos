package com.example.playjuegosfuncional

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_preferences.*

class Preferences : AppCompatActivity() {
    var option : String = "No has pulsado ninguna opcion"
    private var score:kotlin.String? = ""
    var checked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)

        val sb = findViewById(R.id.seekBar1) as SeekBar
        val rb = findViewById(R.id.ratingBar1) as RatingBar
        val fab : FloatingActionButton = findViewById(R.id.fabOk)
        val rGroup = findViewById(R.id.radioGroup) as RadioGroup


        rGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {

            override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
                val checkedRadioButton = rGroup.findViewById<RadioButton>(checkedId)
                option = checkedRadioButton.text.toString()
                checked = true
            }
        })

        rb.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener{
                    ratingBar, rating, fromUser ->  sb.progress = rating.toInt()
            }


        sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                rb.rating = progress.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })


        fab.setOnClickListener ( object: View.OnClickListener {
            override fun onClick(view: View?) {
                if (checked) {
                    score = "Puntuacion: " + sb.progress
                }
                Toast.makeText(applicationContext, option + " " +  score, Toast.LENGTH_SHORT).show()
            }
        })

    }

}


