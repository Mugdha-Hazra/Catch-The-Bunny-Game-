package com.example.catchthebunny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Toast.makeText(this,"Welcome", Toast.LENGTH_LONG).show()
    }
    fun changeActivity(view:View){
        val intent=Intent(applicationContext,MainActivity::class.java)
        intent.putExtra("input",editTextTextPersonName.text.toString())
        startActivity(intent)

    }
}