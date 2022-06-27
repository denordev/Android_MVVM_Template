package com.denorapplications.mvvmtemplate.presentation.catslistfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.denorapplications.mvvmtemplate.databinding.FragmentCatsListBinding
import com.denorapplications.mvvmtemplate.getAppComponent
import com.denorapplications.mvvmtemplate.presentation.mainfragment.MainViewModel

class CatsListFragment : Fragment() {

    private var _binding: FragmentCatsListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CatListViewModel by viewModels {
        getAppComponent().viewModelsFactory()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getAppComponent().inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatsListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}