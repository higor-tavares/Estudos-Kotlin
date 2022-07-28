/**
 * Estudo de funções de alta ordem a partir do livro Kotlin em ação
 */
fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun main(args: Array<String>){
    println("(85) 9987-4500.".filter { it in '0'..'9' })
}