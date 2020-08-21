package com.yagi2.navigationsample.view.firstexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.yagi2.navigationsample.R
import com.yagi2.navigationsample.view.main.MainActivity
import com.yagi2.navigationsample.view.main.MainActivityArgs
import com.yagi2.navigationsample.view.main.MainCheckDataParcelable
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_three.*

class FirstFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_first_example, container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController=Navigation.findNavController(view)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        next_button.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_main_to_flow_one)
        )

        requireActivity().onBackPressedDispatcher
                .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {

                        navController.navigate(FirstFragmentDirections.actionExitToActivity(MainCheckDataParcelable(checkFirst = true, checkSecond = false)))

                        if (isEnabled) {
                            isEnabled = false
                        }
                        requireActivity().finish()
                    }
                })
    }
}