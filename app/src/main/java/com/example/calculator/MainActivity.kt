package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdding()
        initMinus()
    }

    data class Numbers(val number1: Double, val number2: Double)    //клас даних для повернення двох значень з функції


    private fun getNumbers(): Numbers{         //функція отримання значень цифр
        val number1 = num1.text.toString().toDouble()
        val number2 = num2.text.toString().toDouble()
        return Numbers(number1,number2)

    }

    private fun initAdding() = plus.setOnClickListener{     //функція додаток
            val(number1, number2) = getNumbers()
            val resultOfAdding = number1 + number2
            result.text = resultOfAdding.toString()
    }

    private fun initMinus() = minus.setOnClickListener{   //функція віднімання
            val (number1, number2) = getNumbers()
            val resultOfSubtraction = number1 - number2
            result.text = resultOfSubtraction.toString()
    }

    fun initMultiply(view: View) {  //функція множення
            val (number1, number2) = getNumbers()
            val resultOfMultiplication = number1 * number2
            result.text = resultOfMultiplication.toString()
    }

    fun initShare(view: View) {   //функція ділення
        val (number1, number2) = getNumbers()
        if (number2 == 0.toDouble()) {
            result.text = "Ділити на 0 не можна"
        } else {
            val resultOfDivision = number1 / number2
            result.text = resultOfDivision.toString()
        }
    }
}
