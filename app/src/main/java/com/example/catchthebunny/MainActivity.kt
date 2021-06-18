package com.example.catchthebunny

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var score:Int=0
    var imageArray= ArrayList<ImageView>()
    var handler:Handler=Handler()
    var runnable:Runnable= Runnable {  }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent
        val recieved: String? =intent.getStringExtra("input")
        textView2.text ="Welcome $recieved!! "
        score=0
        imageArray= arrayListOf(imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12)

        hideImages()

        object : CountDownTimer(30000,1000) {
            override fun onFinish() {
                Toast.makeText(applicationContext,"Time is up!!", Toast.LENGTH_LONG).show()
                textView.text = "Left: 0"
                handler.removeCallbacks(runnable)
                for(image in imageArray){
                    image.visibility=View.INVISIBLE
                }
            }

            override fun onTick(millisUntilFinished: Long) {
                textView.text = "Left: ${millisUntilFinished/1000}"
            }

        }.start()
    }

    fun hideImages(){
        runnable=object :Runnable{
            override fun run() {
                for(image in imageArray){
                    image.visibility=View.INVISIBLE
                }
                val random=Random()
                val i=random.nextInt(12 - 0)
            imageArray[i].visibility=View.VISIBLE
                handler.postDelayed(runnable,500)
            }
        }
     handler.post(runnable)
    }

    fun increaseScore(view: View){
        score++
     scoreText.text="Score : $score"

    }
    fun reset(view: View){
        val alertDialog=AlertDialog.Builder(this)
        alertDialog.setTitle("Reset")
        alertDialog.setMessage("Are you sure you want to replay?")
        alertDialog.setPositiveButton("Yes")
        { dialogInterface: DialogInterface, i: Int ->Toast.makeText(applicationContext,"Replay",Toast.LENGTH_LONG).show()
            val intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)

        }
        alertDialog.setNegativeButton("No")
        { dialogInterface: DialogInterface, i: Int ->Toast.makeText(applicationContext,"Stop",Toast.LENGTH_LONG).show()
        }
        alertDialog.show()
    }
}