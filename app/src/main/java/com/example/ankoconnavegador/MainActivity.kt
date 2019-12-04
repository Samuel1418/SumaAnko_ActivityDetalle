package com.example.ankoconnavegador

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop

const val SUMA_REQUEST=1
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSumar.setOnClickListener { abrirActivityDetalle(it) }
    }


    fun abrirActivityDetalle(v: View){
        var num1 = textoA.text
        var num2 = textoB.text



            var n1 = Integer.parseInt(num1.toString())
            var n2 = Integer.parseInt(num2.toString())

            val intent = Intent(this, Activity_Detalle::class.java)
            intent.putExtra("num1", n1)
            intent.putExtra("num2", n2)

            startActivityForResult(intent, SUMA_REQUEST)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Check which request we're responding to
        if (requestCode == SUMA_REQUEST) {
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getIntExtra("result", 0)
                miTexto.text = result.toString()

            }
        }
    }
    }
