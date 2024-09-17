package com.example.fuelcalculatorfromscratch11

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvResult = findViewById<TextView>(R.id.textViewTripCostResult)
        val tvPrice = findViewById<TextView>(R.id.textViewPriceResult)
        val tvEfficiency = findViewById<TextView>(R.id.textViewEfficiencyResult)
        val tvDistance = findViewById<TextView>(R.id.textViewDistanceResult)

        val price: Float = intent.getFloatExtra(KEY_PRICE, 0.00f)
        val efficiency = intent.getFloatExtra(KEY_EFFICIENCY, 0f)
        val distance = intent.getFloatExtra(KEY_DISTANCE, 0f)

        val btnNew = findViewById<Button>(R.id.calculateAgain)

        tvPrice.text = price.toString()
        tvEfficiency.text = efficiency.toString()
        tvDistance.text = distance.toString()

        val result = price * (distance/efficiency)

        tvResult.text = "$%.2f".format(result)
        tvPrice.text = "$%.2f/gal".format(price)
        tvEfficiency.text = "%.0f mpg".format(efficiency)
        tvDistance.text = "%.0f miles".format(distance)

        println("Clicou: Result: $result")

        btnNew.setOnClickListener {
            val intent = Intent(this, PriceActivity::class.java)
            startActivity(intent)

            println("Clicou: New trip")

        }
    }
}