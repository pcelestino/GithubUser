package br.org.inec.pcsilveira.githubuser.extension

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat
import java.util.*

class StringExtensionTest {

    @Test
    fun formatDateToCalendar() {
        val englishDate = "2017-12-28"
        val englishFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val dateParsed = englishFormat.parse(englishDate)
        val expected = Calendar.getInstance()
        expected.time = dateParsed

        val result = englishDate.formatDateToCalendar()

        assertEquals(expected, result)
    }

    @Test
    fun formatToBrazilianDate() {
        val englishDate = "2017-12-28"
        val expected = "28/12/2017"

        val result = englishDate.formatToBrazilianDate()

        assertEquals(expected, result)
    }

    @Test
    fun limitsUpTo() {
        val message = "Apenas um teste de mensagem"
        val expected = "Apenas um tes..."

        val result = message.limitsUpTo(13)

        assertEquals(expected, result)
    }

}