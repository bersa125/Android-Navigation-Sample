package com.yagi2.navigationsample.view.firstexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yagi2.navigationsample.R

class FirstActivity : AppCompatActivity() {

    companion object {

        fun start(context: Activity) {
            context.startActivity(Intent(context, FirstActivity::class.java))
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_nav_example)
    }
}
