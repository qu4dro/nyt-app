package orlov.nyt.ui.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import orlov.nyt.R
import orlov.nyt.databinding.FragmentBookmarksBinding
import orlov.nyt.domain.model.Article
import orlov.nyt.ui.adapters.ArticlesAdapter
import timber.log.Timber

class BookmarksFragment : Fragment(R.layout.fragment_bookmarks) {

    private val viewModel: BookmarksViewModel by activityViewModels()

    private var _binding: FragmentBookmarksBinding? = null
    val binding
        get() = _binding!!

    private val adapter: ArticlesAdapter = ArticlesAdapter(
        object : ArticlesAdapter.OnItemClickListener {
            override fun onArticleClick(article: Article) {
                val action =
                    BookmarksFragmentDirections.actionBookmarksFragmentToArticleFragment(article)
                findNavController().navigate(action)
            }
        },
        ArticlesAdapter.RecyclerType.COMPACT
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookmarksBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        setupUI()
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    binding.apply {
                        rvSavedNews.visibility = if (uiState.isEmpty) View.GONE else View.VISIBLE
                        groupHint.visibility = if (uiState.isEmpty) View.VISIBLE else View.GONE
                    }
                    adapter.submitList(uiState.articleItems)
                    (view.parent as? ViewGroup)?.doOnPreDraw {
                        startPostponedEnterTransition()
                    }
                }
            }
        }

    }

    private fun setupUI() {
        binding.rvSavedNews.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}