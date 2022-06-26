package com.denorapplications.mvvmtemplate.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.denorapplications.mvvmtemplate.R
import com.denorapplications.mvvmtemplate.databinding.FragmentMainBinding
import com.denorapplications.mvvmtemplate.di.AppComponent
import com.denorapplications.mvvmtemplate.di.viewModelCreator
import com.denorapplications.mvvmtemplate.domain.repositories.DatabaseRepository
import com.denorapplications.mvvmtemplate.domain.usecases.GetItemByIdUseCase
import com.denorapplications.mvvmtemplate.getAppComponent
import com.denorapplications.mvvmtemplate.presentation.base.BaseFragment
import javax.inject.Inject


class MainFragment : BaseFragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var appComponent: AppComponent

    private val viewModel: MainViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        appComponent = getAppComponent()
        appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}