package com.yagi2.navigationsample.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.yagi2.navigationsample.R
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

       /* navController.currentBackStackEntry?.savedStateHandle?.getLiveData<Boolean>(FirstActivity.FIRST_EXAMPLE_CHECKED_KEY)?.observe(viewLifecycleOwner
                , Observer<Boolean> { t -> //Update the label only on back from three
            imgToFirstGraphExample.visibility= if(t) View.VISIBLE else View.GONE
        })*/

        arguments.run {
            val args= this?.let { MainActivityArgs.fromBundle(it) }

            if(args!=null) {
                imgToFirstGraphExample.visibility = if (args.checkParcel.checkFirst) View.VISIBLE else View.GONE
                imgToSecondGraphExample.visibility = if (args.checkParcel.checkSecond) View.VISIBLE else View.GONE
            }
        }

        btnToFirstGraphExample.setOnClickListener {
            navController.navigate(MainFragmentDirections.actionNextToFirstActivity())
            requireActivity().finish()
        }
        btnToSecondGraphExample.setOnClickListener {
            navController.navigate(MainFragmentDirections.actionNextToSecondActivity())
            requireActivity().finish()
        }
    }

}