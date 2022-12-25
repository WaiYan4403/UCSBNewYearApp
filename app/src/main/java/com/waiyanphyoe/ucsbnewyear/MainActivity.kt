package com.waiyanphyoe.ucsbnewyear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var txtResult:TextView
    var usedNumbers = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnPick:Button = findViewById(R.id.btnPick)
        txtResult = findViewById(R.id.txtresult)

        btnPick.setOnClickListener {
            pickRandomNumber()
        }
    }

    private fun pickRandomNumber(){
        if(usedNumbers.size >= 280){
            txtResult.text = "END"
        }
        else{
            var randNum = 0
            do {
                randNum = Random().nextInt(281)
            }while (usedNumbers.contains(randNum))

            usedNumbers.add(randNum)
            txtResult.text = String.format("%03d", randNum)
        }
    }
}