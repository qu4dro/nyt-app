package orlov.nyt.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import orlov.nyt.databinding.ItemArticleBigBinding
import orlov.nyt.databinding.ItemArticleSmallBinding
import orlov.nyt.domain.model.Article

class ArticlesAdapter(private val onClickPhoto: (Article) -> Unit) :
    ListAdapter<Article, RecyclerView.ViewHolder>(ArticleDiffUtil) {

    enum class VIEW_TYPE {

    }

    inner class ArticlesBigViewHolder(
        private val binding: ItemArticleBigBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.article = article
            binding.executePendingBindings()
            binding.root.setOnClickListener { onClickPhoto(article) }
        }
    }

    inner class ArticlesSmallViewHolder(
        private val binding: ItemArticleSmallBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.article = article
            binding.executePendingBindings()
            binding.root.setOnClickListener { onClickPhoto(article) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 5 == 0) 1
        else 2

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            1 -> return ArticlesBigViewHolder(
                ItemArticleBigBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            2 -> return ArticlesSmallViewHolder(
                ItemArticleSmallBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
           else -> return ArticlesSmallViewHolder(
               ItemArticleSmallBinding.inflate(
                   LayoutInflater.from(parent.context),
                   parent,
                   false
               )
           )
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val article = getItem(position)
        when(holder.itemViewType) {
            1 -> {
                val viewHolderBig = holder as ArticlesBigViewHolder
                viewHolderBig.bind(article)
            }
            2-> {
                val viewHolderSmall = holder as ArticlesSmallViewHolder
                viewHolderSmall.bind(article)
            }
        }

    }

    private object ArticleDiffUtil : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }


}