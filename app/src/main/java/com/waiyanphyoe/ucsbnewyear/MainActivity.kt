package com.waiyanphyoe.ucsbnewyear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var txtNum1:TextView
    lateinit var txtNum2:TextView
    lateinit var txtNum3:TextView
    var usedNumbers = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnPick:Button = findViewById(R.id.btnPick)
        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
        txtNum3 = findViewById(R.id.txtNum3)

        btnPick.setOnClickListener {
            pickRandomNumber()
        }
    }

    private fun pickRandomNumber(){
        if(usedNumbers.size >= 280){
            txtNum1.text = "E"
            txtNum2.text = "N"
            txtNum3.text = "D"
        }
        else{
            var randNum = 0
            do {
                randNum = Random().nextInt(281)
            }while (usedNumbers.contains(randNum))
            usedNumbers.add(randNum)
            txtNum1.text = "-"
            txtNum2.text = "-"
            txtNum3.text = "-"
            var strNumber = randNum.toString()

            if(strNumber.length == 1){
                strNumber = "00" + strNumber
            }
            else if(strNumber.length == 2){
                strNumber = "0" + strNumber
            }
            Handler().postDelayed({
                txtNum1.text = strNumber.get(0).toString()
                //txtResult.text = String.format("%03d", randNum)
            },1000)
            Handler().postDelayed({
                txtNum2.text = strNumber.get(1).toString()
                //txtResult.text = String.format("%03d", randNum)
            },2000)
            Handler().postDelayed({
                txtNum3.text = strNumber.get(2).toString()
                //txtResult.text = String.format("%03d", randNum)
            },3000)
        }
    }
}