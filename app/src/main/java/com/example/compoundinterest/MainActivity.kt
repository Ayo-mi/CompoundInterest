package com.example.compoundinterest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.compoundinterest.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat
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
                val n = 365
                var s = 1 + (rate/n)
                s = s.pow(n * time)
                val comp = (p * s).toFloat()
                val initVal = (comp * p).toFloat()
                val dec = DecimalFormat("#,###.00")

                closeKeyBoard()

                vieww.resTxt.text = "Compound Interest: \n$${dec.format(comp)}\n\nInitial Value: \n$${dec.format(initVal)}"
            }catch (e: Exception){
                //vieww.resTxt.text = "Invalid action"
                Snackbar.make(vieww.root, "Invalid action", Snackbar.LENGTH_LONG).show()
                //Toast.makeText(this, "Invalid action", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun closeKeyBoard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}