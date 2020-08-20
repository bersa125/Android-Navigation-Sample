package com.yagi2.navigationsample.view.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yagi2.navigationsample.R

class MainActivity : AppCompatActivity() {

    companion object{

        fun start(context: Activity){
            context.startActivity(Intent(context,MainActivity::class.java))
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
