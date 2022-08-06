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

fun<T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null
): String{
    val result = StringBuilder(prefix)
    for((index, element) in this.withIndex()){
        if(index > 0) result.append(separator)
        val str = transform?.invoke(element) ?: element.toString()
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}
fun <T : Number> oneHalf(value:T): Double {
    return value.toDouble() / 2.0
}
fun <T: Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}
fun main(args: Array<String>){
    println("(85) 9987-4500.".filter { it in '0'..'9' })
    println(listOf("Kilindo","Picole").joinToString(postfix = "!!", transform = {it -> it.uppercase()}))
    println(oneHalf(10))
    println(max("java","kotlin"))
    println(max(15,10))
}