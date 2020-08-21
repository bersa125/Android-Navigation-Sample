package com.yagi2.navigationsample.view.firstexample

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
import kotlinx.android.synthetic.main.fragment_one.text
import kotlinx.android.synthetic.main.fragment_three.*
import kotlin.properties.Delegates

class FlowFragment : Fragment() {

    companion object{

        const val ON_BACK_NUMBER_PARAMETER_KEY= "number"

    }

    private lateinit var navController : NavController
    private var number by Delegates.notNull<Int>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        number = arguments?.let {
            FlowFragmentArgs.fromBundle(it).number
        }!!

        return when (number) {
            1 -> inflater.inflate(R.layout.fragment_one, container, false)
            2 -> inflater.inflate(R.layout.fragment_two, container, false)
            3 -> inflater.inflate(R.layout.fragment_three, container, false)
            4 -> inflater.inflate(R.layout.fragment_one, container, false)
            else -> throw IllegalArgumentException()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        navController.currentBackStackEntry?.savedStateHandle?.getLiveData<Int>(ON_BACK_NUMBER_PARAMETER_KEY)?.observe(viewLifecycleOwner
                , Observer<Int> { t -> //Update the label only on back from three
            if (navController.currentDestination?.id == R.id.fragment_two && navController.graph.id == R.id.first_nav_graph)
                text?.text = t.toString()
        })


        text?.text=arguments.run {
            FlowFragmentArgs.fromBundle(this!!).number.toString()
        }

        if(navController.currentDestination?.id == R.id.fragment_three) {
            if (navController.graph.id != R.id.first_nav_graph) {
                checkbox_modify_previous_label.visibility = View.GONE
            } else {
                checkbox_modify_previous_label.visibility = View.VISIBLE
            }
        }

        next_button.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_next_flow)
        )

        back_button?.setOnClickListener {
            //Influence a fragment back in the
            navController.navigate(FlowFragmentDirections.actionBackWithArgumentsFlow(4))
        }

        //Set onBack behaviour for fragmentThree
        requireActivity().onBackPressedDispatcher
                .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {

                        if (navController.currentDestination?.id == R.id.fragment_three && navController.graph.id == R.id.first_nav_graph && checkbox_modify_previous_label.isChecked){
                            navController.previousBackStackEntry?.savedStateHandle?.set(ON_BACK_NUMBER_PARAMETER_KEY, 5)
                        }

                        if (isEnabled) {
                            isEnabled = false
                            requireActivity().onBackPressed()
                        }
                    }
                })
    }

    override fun onDestroyView() {
        //Toast.makeText(context,"Destroying View",Toast.LENGTH_SHORT).show()
        super.onDestroyView()
    }

    override fun onDestroy() {
        //Toast.makeText(context,"Destroying Fragment",Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }

}
