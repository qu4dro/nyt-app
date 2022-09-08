package orlov.nyt.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import orlov.nyt.R
import orlov.nyt.databinding.FragmentHomeBinding
import orlov.nyt.ui.viewmodels.NewsViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: NewsViewModel by activityViewModels()

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
        viewModel.fetchTopNews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}