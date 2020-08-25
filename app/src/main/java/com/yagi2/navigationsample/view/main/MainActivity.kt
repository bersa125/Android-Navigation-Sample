package com.yagi2.navigationsample.view.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import com.yagi2.navigationsample.R

class MainActivity : AppCompatActivity() {

    companion object {

        fun start(context: Activity) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //pass the intet Extras to the fragment
        findNavController(this, R.id.fragment).setGraph(R.navigation.main_nav_graph, intent.extras)
    }

}
