fun main() {
    println("Программа считает повторяющие символы в строке (например: aaabbcccddd)")

        try {
            println("Введите строку:")
            val input = readLine()?.trim()// трим убирает пробелы в начале и конце строки

            val result = input?.let { countConsecutiveChars(it) }
            println("Результат: $result")
        } catch (e: IllegalArgumentException) { //обработать ошибку
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
            //Проверяет, равен ли текущий символ символу. проверяет, что символ не пробел.
            count++
        } else {
            appendCharInfo(result, currentChar, count)
            //Вызывает функцию, которая добавляет информацию о текущем символе и его количестве в результат.
            currentChar = str[i]
            count = 1
        }
    }

    appendCharInfo(result, currentChar, count)// инф о последн символе

    return result.toString()
}

private fun appendCharInfo(builder: StringBuilder, char: Char, count: Int) {
    // добавл инф о символе в результат
    builder.append(char)
    if (count > 1 && char != ' ') {// если символ выполн больше 1 раза=>
        builder.append(count)//добавл кол-во повторений
    }
}