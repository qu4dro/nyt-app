package orlov.nyt.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import orlov.nyt.R
import orlov.nyt.databinding.FragmentArticleBinding

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
    }

    private fun setupUI() {
        binding.apply {
            article = args.article
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}