package orlov.nyt.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import orlov.nyt.R
import orlov.nyt.databinding.FragmentSearchBinding
import orlov.nyt.domain.model.Article
import orlov.nyt.ui.adapters.ArticlesAdapter
import orlov.nyt.ui.bookmarks.BookmarksFragmentDirections

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val viewModel: SearchViewModel by activityViewModels()

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

    private var _binding: FragmentSearchBinding? = null
    val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
    }

    private fun setupObservers() {

    }

    private fun setupUI() {
        showKeyBoard()
        binding.apply {
            rvSearchedNews.adapter = adapter
            edtSearch.doOnTextChanged { text, _, _, _ ->
            }
        }

    }

    private fun showKeyBoard() {
        binding.edtSearch.requestFocus()
        val imm =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm!!.showSoftInput(binding.edtSearch, InputMethodManager.SHOW_IMPLICIT)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}