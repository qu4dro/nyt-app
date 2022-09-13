package orlov.nyt.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import orlov.nyt.databinding.ItemArticleBigBinding
import orlov.nyt.databinding.ItemArticleSavedBinding
import orlov.nyt.databinding.ItemArticleSmallBinding
import orlov.nyt.domain.model.Article

class ArticlesAdapter(
    private val clickListener: OnItemClickListener,
    private val recyclerType: RecyclerType = RecyclerType.DEFAULT
) :
    ListAdapter<Article, RecyclerView.ViewHolder>(ArticleDiffUtil) {

    interface OnItemClickListener {
        fun onArticleClick(article: Article)
    }

    enum class RecyclerType {
        DEFAULT,
        COMPACT
    }

    inner class ArticlesBigViewHolder(
        private val binding: ItemArticleBigBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.article = article
            binding.executePendingBindings()
            binding.root.setOnClickListener { clickListener.onArticleClick(article) }
        }
    }

    inner class ArticlesSmallViewHolder(
        private val binding: ItemArticleSmallBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.article = article
            binding.executePendingBindings()
            binding.root.setOnClickListener { clickListener.onArticleClick(article) }
        }
    }

    inner class ArticlesSavedViewHolder(
        private val binding: ItemArticleSavedBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.article = article
            binding.executePendingBindings()
            binding.root.setOnClickListener { clickListener.onArticleClick(article) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 5 == 0) 1
        else 2

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val bigViewHolder = ArticlesBigViewHolder(
            ItemArticleBigBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        val smallViewHolder = ArticlesSmallViewHolder(
            ItemArticleSmallBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        val savedViewHolder = ArticlesSavedViewHolder(
            ItemArticleSavedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        return when (recyclerType) {
            RecyclerType.DEFAULT -> if (viewType == 1) bigViewHolder else smallViewHolder
            RecyclerType.COMPACT -> savedViewHolder
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val article = getItem(position)
        when (holder) {
            is ArticlesBigViewHolder -> holder.bind(article)
            is ArticlesSmallViewHolder -> holder.bind(article)
            is ArticlesSavedViewHolder -> holder.bind(article)
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