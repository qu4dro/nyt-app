package orlov.nyt.ui.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import orlov.nyt.R
import orlov.nyt.utils.DateUtils.formatDate
import orlov.nyt.utils.setBlackAndWhite

@BindingAdapter("imageUrl")
fun bindArticlePhoto(imgView: ImageView, url: String?) {
    imgView.load(url) {
        placeholder(R.drawable.image_placeholder)
        error(R.drawable.image_placeholder)

    }
    imgView.setBlackAndWhite()
}

@BindingAdapter("author", "date")
fun bindAuthorAndDate(textView: TextView, author: String, date: String) {
    var formattedText = ""
    val formattedDate = formatDate(date)
    formattedText += "$author / $formattedDate"
    textView.text = formattedText
}

@BindingAdapter("date")
fun bindDate(textView: TextView, date: String) {
    textView.text = formatDate(date)
}
