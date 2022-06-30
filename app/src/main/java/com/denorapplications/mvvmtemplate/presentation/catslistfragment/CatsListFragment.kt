package com.denorapplications.mvvmtemplate.presentation.catslistfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.denorapplications.mvvmtemplate.databinding.FragmentCatsListBinding
import com.denorapplications.mvvmtemplate.getAppComponent

class CatsListFragment : Fragment() {

    private var _binding: FragmentCatsListBinding? = null
    private val binding get() = _binding!!
    private val catsAdapter: CatsAdapter by lazy { CatsAdapter() }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        initViews()
    }

    private fun initViews() = with(binding) {
        catsRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = catsAdapter
        }
    }

    private fun initObservers() {
        lifecycleScope.launchWhenCreated {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getCatsList()
                viewModel.catsList.collect { state ->
                    when {
                        state?.isLoading!! -> {
                            showProgressBar(true)
                            showConnectionErrorView(false)
                        }
                        !state.isLoading && !state.error.isNullOrEmpty() -> {
                            showProgressBar(false)
                            showConnectionErrorView(true)
                        }
                        !state.isLoading && !state.list.isNullOrEmpty() -> {
                            showProgressBar(false)
                            showConnectionErrorView(false)
                            catsAdapter.submitList(state.list)
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showProgressBar(isVisible: Boolean) = with(binding.progressBar){
        visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    private fun showConnectionErrorView(isVisible: Boolean) = with(binding.errorTextView) {
        visibility = if (isVisible) View.VISIBLE else View.GONE
    }

}
