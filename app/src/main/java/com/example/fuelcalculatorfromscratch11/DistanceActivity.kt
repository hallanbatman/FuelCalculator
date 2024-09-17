package com.example.fuelcalculatorfromscratch11

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_DISTANCE = "DistanceActivity.KEY_INPUT_DISTANCE"

class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distance)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val efficiency = intent.getFloatExtra(KEY_EFFICIENCY, 0f)
        val price = intent.getFloatExtra(KEY_PRICE, 0f)

        val edtDistance = findViewById<TextInputEditText>(R.id.editDistance)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {

        if (edtDistance.text.toString() == "") {
            Snackbar.make(it, "Please enter a value", Snackbar.LENGTH_SHORT).show()
        }
            else {

                val distance = edtDistance.text.toString().toFloat()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(KEY_DISTANCE, distance)
            intent.putExtra(KEY_EFFICIENCY, efficiency)
            intent.putExtra(KEY_PRICE, price)

            startActivity(intent)

            println("Clicou: Distance: " + distance + " miles / Efficiency: " + efficiency + " mpg / Price: " + price)

            }
        }
    }
}