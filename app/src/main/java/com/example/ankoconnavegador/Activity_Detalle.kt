package com.example.ankoconnavegador

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity__detalle.*
import kotlinx.android.synthetic.main.activity_main.*

class Activity_Detalle : AppCompatActivity() {

    var a=0
    var b=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__detalle)
        a = intent.getIntExtra("num1", 0) //el cero es para que no salte error
        b = intent.getIntExtra("num2", 0)

        btnVolver.setOnClickListener {retornarResultado(it)  }
    }


    fun retornarResultado(it: View?) {
        val result=a+b
        val intent = Intent()
        intent.putExtra("result", result)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
