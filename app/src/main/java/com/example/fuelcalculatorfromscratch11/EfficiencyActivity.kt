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

const val KEY_EFFICIENCY = "EfficiencyActivity.KEY_INPUT_EFFICIENCY"

class EfficiencyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_efficiency)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val price = intent.getFloatExtra(KEY_PRICE, 0f)

        val edtEfficiency = findViewById<TextInputEditText>(R.id.editFuelEfficiency)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {

        if (edtEfficiency.text.toString() == "") {
            Snackbar.make(it, "Please enter a value", Snackbar.LENGTH_SHORT).show()
        }
            else{

                val efficiency = edtEfficiency.text.toString().toFloat()
                val intent = Intent(this, DistanceActivity::class.java)
                intent.putExtra(KEY_EFFICIENCY, efficiency)
                intent.putExtra(KEY_PRICE, price)

                startActivity(intent)

            println("Clicou: Efficiency: " + efficiency + "mpg / Price: $" + price)
            }
        }
    }
}