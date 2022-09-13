package orlov.nyt.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import orlov.nyt.R
import orlov.nyt.databinding.FragmentArticleBinding
import orlov.nyt.domain.model.Article
import timber.log.Timber

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private val viewModel: ArticleViewModel by activityViewModels()

    private var _binding: FragmentArticleBinding? = null
    val binding
        get() = _binding!!

    private val args: ArticleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArticleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()

        Timber.d(args.article.toString())

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.selectedArticles.collect { articles ->
                    val saveState = articles.map { it.id }.filter { it == args.article.id }.contains(args.article.id)
                    updateSaveIconState(saveState)
                    binding.toolbar.setOnMenuItemClickListener { item ->
                        if (item.itemId == R.id.saveArticle) {
                            if (saveState) deleteArticle(args.article) else saveArticle(args.article.copy())
                        }
                        true
                    }
                }
            }
        }
    }

    private fun setupUI() {
        binding.apply {
            article = args.article
            toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
            tvShare.setOnClickListener { }
            tvSource.setOnClickListener { }
            fabComments.setOnClickListener { }
        }
    }

    private fun saveArticle(article: Article) {
        viewModel.saveArticle(article)
        Toast.makeText(requireContext(), R.string.article_bookmarked, Toast.LENGTH_LONG).show()
    }

    private fun deleteArticle(article: Article) {
        viewModel.deleteArticle(article)
        Toast.makeText(requireContext(), R.string.article_deleted, Toast.LENGTH_LONG).show()
    }

    private fun updateSaveIconState(saveState: Boolean) {
        binding.toolbar.menu.findItem(R.id.saveArticle).apply {
            if (saveState) setIcon(R.drawable.ic_unbookmark) else setIcon(R.drawable.ic_bookmark)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}