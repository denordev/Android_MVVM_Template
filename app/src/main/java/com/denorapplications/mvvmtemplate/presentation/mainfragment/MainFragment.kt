package com.denorapplications.mvvmtemplate.presentation.mainfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.denorapplications.mvvmtemplate.databinding.FragmentMainBinding
import com.denorapplications.mvvmtemplate.getAppComponent
import com.denorapplications.mvvmtemplate.presentation.base.BaseFragment

class MainFragment : BaseFragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels {
        getAppComponent().viewModelsFactory()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getAppComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    private fun initViews() = with(binding) {
        showCatsButton.setOnClickListener {
            navigate(MainFragmentDirections.actionMainFragmentToCatsListFragment())
        }
    }

    private fun initObservers() {
        viewModel.alive()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
