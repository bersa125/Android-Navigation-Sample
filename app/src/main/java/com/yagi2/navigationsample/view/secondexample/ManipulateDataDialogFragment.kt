package com.yagi2.navigationsample.view.secondexample

import android.app.Dialog
import android.content.DialogInterface

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController


class ManipulateDataDialogFragment : DialogFragment() {

    companion object {

        const val COUNTER_MANIPULATION_BACKSTACK_KEY = "manipulate"
        const val TEXT_ARGUMENT_KEY="text"

        fun newInstance(title: String?): ManipulateDataDialogFragment {
            val frag = ManipulateDataDialogFragment()
            val args = Bundle()
            args.putString("title", title)
            frag.arguments = args
            return frag
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title: String = arguments?.getString("title") ?: ""

        val navController = findNavController()

        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setTitle(title)
        alertDialogBuilder.setMessage("Manipulate the counter?")
        alertDialogBuilder.setPositiveButton("+1", DialogInterface.OnClickListener { dialog, which ->
            //Action to increase
            navController.previousBackStackEntry?.savedStateHandle?.set(COUNTER_MANIPULATION_BACKSTACK_KEY, true)
            navController.popBackStack()
        })
        alertDialogBuilder.setNegativeButton("-1", DialogInterface.OnClickListener { dialog, which ->
            navController.previousBackStackEntry?.savedStateHandle?.set(COUNTER_MANIPULATION_BACKSTACK_KEY, false)
            navController.popBackStack()
        })
        alertDialogBuilder.setOnCancelListener {
            navController.navigate(ManipulateDataDialogFragmentDirections.actionNoChanges("No Changes"))
        }
        return alertDialogBuilder.create()
    }

}