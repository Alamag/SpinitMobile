package dev.spinit.school.mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var etFirstNum : EditText
    private lateinit var etSecondNum : EditText
    private lateinit var tvSum : TextView
    private lateinit var bSum : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFirstNum = findViewById(R.id.et_first_num)
        etSecondNum = findViewById(R.id.et_second_num)
        tvSum = findViewById(R.id.tv_sum)
        bSum = findViewById(R.id.b_sum)

        tvSum.text = savedInstanceState?.getString("Sum")
        
        bSum.setOnClickListener {
            val firstNum = etFirstNum.text.toString().toIntOrNull() ?: 0
            val secondNum = etSecondNum.text.toString().toIntOrNull() ?: 0
            val sum = firstNum + secondNum
            tvSum.text = sum.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Sum", tvSum.text.toString())
    }
}