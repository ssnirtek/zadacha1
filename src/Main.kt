fun main() {
    println("Программа считает повторяющие символы в строке (например: aaabbcccddd)")

        try {
            println("Введите строку:")
            val input = readLine()?.trim()

            val result = input?.let { countConsecutiveChars(it) }
            println("Результат: $result")
        } catch (e: IllegalArgumentException) {
            println("Ошибка: ${e.message}")
        }
        finally {
            println();
        }

}
fun countConsecutiveChars(str: String): String {
    if (str.isEmpty()) return ""

    val result = StringBuilder()
    var currentChar = str[0]
    var count = 1

    for (i in 1 until str.length) {
        if (str[i] == currentChar && currentChar != ' ') {
            count++
        } else {
            appendCharInfo(result, currentChar, count)
            currentChar = str[i]
            count = 1
        }
    }

    appendCharInfo(result, currentChar, count)

    return result.toString()
}

private fun appendCharInfo(builder: StringBuilder, char: Char, count: Int) {
    builder.append(char)
    if (count > 1 && char != ' ') {
        builder.append(count)
    }
}