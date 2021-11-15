package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton = findViewById<Button>(R.id.button)
        rollButton.setOnClickListener()
        {
            rollDice()
        }
    }
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = diceRoll.toString()
        val diceImage = findViewById<ImageView>(R.id.imageView)
        val drawableResource = when(diceRoll)
        {
                1->R.drawable.dice_1
                2->R.drawable.dice_2
                3->R.drawable.dice_3
                4->R.drawable.dice_4
                5->R.drawable.dice_5
                else->R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
}
class Dice(val numSide: Int){
    fun roll(): Int{
        return (1..numSide).random()
    }
}