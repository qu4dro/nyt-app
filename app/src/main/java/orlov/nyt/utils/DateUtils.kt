package orlov.nyt.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun formatDate(date: String): String {
        val outputFormat: DateFormat = SimpleDateFormat("d MMM HH:mm", Locale.ENGLISH)
        val inputFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
        return outputFormat.format(inputFormat.parse(date))
    }

    fun getToday(): String =
        SimpleDateFormat("EEEE, d MMM", Locale.ENGLISH).format(Calendar.getInstance().time)

}