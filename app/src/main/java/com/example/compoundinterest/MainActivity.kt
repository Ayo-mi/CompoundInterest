package com.example.compoundinterest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.compoundinterest.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var vieww: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initialize the binding object here
        vieww = ActivityMainBinding.inflate(layoutInflater)

        setContentView(vieww.root)
        vieww.principalTxt.requestFocus()

        vieww.btnCal.setOnClickListener {
            try {
            val p = vieww.principalTxt.text.toString().toDouble()
            val rate = vieww.rateTxt.text.toString().toDouble()
            val time = vieww.timeTxt.text.toString().toDouble()
            val n = 12
            var s = 1 + (rate/n)
            s = s.pow(n * time)
            val comp = (p * s).toFloat()
            val initVal = (comp * p).toFloat()

            vieww.resTxt.text = "Compound Interest: $comp\nInitial Value: $initVal"
            }catch (e: Exception){
                vieww.resTxt.text = "Invalid action"
            }
        }

    }
}