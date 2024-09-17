package com.example.fuelcalculatorfromscratch11

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_PRICE = "EfficiencyActivity.KEY_INPUT_PRICE"

class PriceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_price)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtPrice = findViewById<TextInputEditText>(R.id.editFuelPrice)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            if (edtPrice.text.toString() == "") {
                Snackbar
                    .make(it, "Please enter a value", Snackbar.LENGTH_SHORT)
                    .show()
            } else {

                val price = edtPrice.text.toString().toFloat()
                val intent = Intent(this, EfficiencyActivity::class.java)
                intent.putExtra(KEY_PRICE, price)

                startActivity(intent)

                println("Clicou: Price: $" + price)
            }
        }
    }
}