package com.yagi2.navigationsample.view.secondexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.yagi2.navigationsample.R
import com.yagi2.navigationsample.view.firstexample.FirstFragmentDirections
import com.yagi2.navigationsample.view.main.MainCheckDataParcelable
import com.yagi2.navigationsample.view.secondexample.ManipulateDataDialogFragment.Companion.COUNTER_MANIPULATION_BACKSTACK_KEY
import com.yagi2.navigationsample.view.secondexample.ManipulateDataDialogFragment.Companion.TEXT_ARGUMENT_KEY
import kotlinx.android.synthetic.main.fragment_second_example.*

class SecondFragment : Fragment(){

    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second_example,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val  counter =arguments?.let {//Exception launched in case it's not defined
            SecondFragmentArgs.fromBundle(it).value
        } ?: 0

        arguments?.get(TEXT_ARGUMENT_KEY).toString().let {
            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
        }

        labelCounter.text = counter.toString()


        navController.currentBackStackEntry?.savedStateHandle?.getLiveData<Boolean>(COUNTER_MANIPULATION_BACKSTACK_KEY)?.observe(viewLifecycleOwner
                , Observer<Boolean> { t -> //Update the label
            if(t){
                labelCounter.text = ((labelCounter.text as String).toInt()+1).toString()
            }else{
                labelCounter.text = ((labelCounter.text as String).toInt()-1).toString()
            }

        })

        btnDialogSpawn.setOnClickListener {
            navController.navigate(SecondFragmentDirections.actionSpawnDialog())
        }

        requireActivity().onBackPressedDispatcher
                .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {

                        navController.navigate(SecondFragmentDirections.actionExitToActivity(MainCheckDataParcelable(checkFirst = false, checkSecond = true)))
                        if (isEnabled) {
                            isEnabled = false
                        }
                        requireActivity().finish()
                    }
                })
    }

}