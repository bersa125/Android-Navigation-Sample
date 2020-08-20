package com.yagi2.navigationsample.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yagi2.navigationsample.R
import com.yagi2.navigationsample.view.firstexample.FirstActivity
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnToFirstGraphExample.setOnClickListener {
            FirstActivity.start(requireActivity())
        }
    }

}