package orlov.nyt.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.google.android.material.chip.Chip
import kotlinx.coroutines.launch
import orlov.nyt.R
import orlov.nyt.databinding.FragmentHomeBinding
import orlov.nyt.ui.adapters.ArticlesAdapter


class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by activityViewModels()
    private val adapter = ArticlesAdapter {}

    private var _binding: FragmentHomeBinding? = null
    val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    when (uiState.loadState) {
                        LoadState.LOADING -> {setLoadingUI()}
                        LoadState.ERROR -> {setErrorUI()}
                        LoadState.SUCCESS -> {
                            adapter.submitList(uiState.articleItems)
                            setSuccessUI()
                        }
                    }
                }
            }
        }
    }

    private fun setupUI() {
        binding.apply {
            rvTrendingNews.adapter = adapter
            rvTrendingNews.layoutManager = GridLayoutManager(requireActivity(), 2).also {
                it.spanSizeLookup = object : SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return when (adapter.getItemViewType(position)) {
                            2 -> 1
                            1 -> 2
                            else -> 1
                        }
                    }
                }
            }

            viewModel.uiState.value.sections.forEach { section ->
                val chip = Chip(requireContext())
                chip.text = section
                chip.setOnClickListener {
                    viewModel.selectSection(section)
                    viewModel.fetchTopNews()
                }
                chipsSection.addView(chip)
            }

            swipeRefresh.setOnRefreshListener {
                viewModel.fetchTopNews()
            }
        }
    }

    private fun setLoadingUI() {
        binding.apply {
            progress.visibility = View.VISIBLE
            swipeRefresh.isRefreshing = true
        }
    }

    private fun setErrorUI() {
        binding.apply {
            progress.visibility = View.GONE
            swipeRefresh.isRefreshing = false
        }
    }

    private fun setSuccessUI() {
        binding.apply {
            progress.visibility = View.GONE
            swipeRefresh.isRefreshing = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}