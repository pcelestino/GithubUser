package br.org.inec.pcsilveira.githubuser.extension

import java.text.SimpleDateFormat
import java.util.*

fun String.formatDateToCalendar(): Calendar {
    val englishFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    val dateParsed = englishFormat.parse(this.substring(0, 10))
    val date = Calendar.getInstance()
    date.time = dateParsed
    return date
}

fun String.formatToBrazilianDate(): String {
    val brazilianFormat = "dd/MM/yyyy"
    return SimpleDateFormat(brazilianFormat, Locale("pt", "br"))
            .format(this.formatDateToCalendar().time)
}

fun String?.limitsUpTo(characters: Int): String {
    this?.let {
        if (this.length > characters) {
            val firstCharacter = 0
            return "${this.substring(firstCharacter, characters)}..."
        }
    }
    return ""
}