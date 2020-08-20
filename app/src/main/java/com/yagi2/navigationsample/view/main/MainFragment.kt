package com.yagi2.navigationsample.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.yagi2.navigationsample.R
import com.yagi2.navigationsample.view.firstexample.FirstActivity
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(){

    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController=Navigation.findNavController(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnToFirstGraphExample.setOnClickListener {
            navController.navigate(MainFragmentDirections.actionNextToFirst())
        }
        btnToSecondGraphExample.setOnClickListener {
            navController.navigate(MainFragmentDirections.actionNextToSecond())
        }
    }

}