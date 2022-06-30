package com.denorapplications.mvvmtemplate.presentation.base

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.denorapplications.mvvmtemplate.presentation.MainActivity

open class BaseFragment : Fragment() {

    private val navController by lazy { findNavController() }

    fun showToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    fun navigate(action: Int, bundle: Bundle? = null) {
        navController.navigate(action, bundle)
    }

    fun navigate(direction: NavDirections, args: Bundle? = null) {
        navController.navigate(direction.actionId, args)
    }

    fun navigateUp() {
        navController.navigateUp()
    }

    fun getMainActivity() = activity as MainActivity?
}
