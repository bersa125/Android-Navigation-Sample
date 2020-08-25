package com.yagi2.navigationsample.view.secondexample

import android.app.Dialog
import android.content.DialogInterface

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


class ManipulateDataDialogFragment : DialogFragment() {

    companion object {

        fun newInstance(title: String?): ManipulateDataDialogFragment {
            val frag = ManipulateDataDialogFragment()
            val args = Bundle()
            args.putString("title", title)
            frag.arguments = args
            return frag
        }
    }

    private val args by navArgs<ManipulateDataDialogFragmentArgs>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title: String = arguments?.getString("title") ?: ""

        val navController = findNavController()

        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setTitle(title)
        alertDialogBuilder.setMessage("Manipulate the counter?")
        alertDialogBuilder.setPositiveButton("+1", DialogInterface.OnClickListener { dialog, which ->
            //Action to increase
            navController.navigate(ManipulateDataDialogFragmentDirections.actionUpdate(args.counter + 1))
        })
        alertDialogBuilder.setNegativeButton("-1", DialogInterface.OnClickListener { dialog, which ->
            navController.navigate(ManipulateDataDialogFragmentDirections.actionUpdate(args.counter - 1))
        })
        return alertDialogBuilder.create()
    }

}