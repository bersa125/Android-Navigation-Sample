package com.yagi2.navigationsample.view.secondexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.yagi2.navigationsample.R
import com.yagi2.navigationsample.utils.navigate
import com.yagi2.navigationsample.view.main.MainCheckDataParcelable
import kotlinx.android.synthetic.main.fragment_second_example.*

class SecondFragment : Fragment() {

    private lateinit var navController: NavController

    private val exitActionIds = listOf(
            R.id.action_exit_to_activity
    )

    private val args by navArgs<SecondFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second_example, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        labelCounter.text = args.counter.toString()

        btnDialogSpawn.setOnClickListener {
            navController.navigate(SecondFragmentDirections.actionSpawnDialog(args.counter), exitActionIds, requireActivity())
        }

        requireActivity().onBackPressedDispatcher
                .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {

                        navController.navigate(SecondFragmentDirections.actionExitToActivity(MainCheckDataParcelable(checkFirst = false, checkSecond = true)), exitActionIds, requireActivity())

                        if (isEnabled) {
                            isEnabled = false
                        }

                    }
                })
    }

}