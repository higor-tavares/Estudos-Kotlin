
fun buildString(
    builderAction:  (StringBuilder) -> Unit //declara um parametro tipo funcao
) : String {
    val sb = StringBuilder()
    builderAction(sb) // passa um StringBuilder como argumento para a lambda
    return sb.toString()
}
//lambda com receptor, semelhante ao with
fun buildString2(
    buildAction: StringBuilder.() -> Unit // declara um parametro tipo funcao com um receptor
) : String {
    val sb = StringBuilder()
    sb.buildAction() // passa um StringBuilder como receptor para a lambda
    return sb.toString()
}
fun main(args: Array<String>){
    val s = buildString {
        it.append("Hello, ") // Utiliza o it como referencia a instância de StringBuilder
        it.append("World!")
    }
    println(s)
    val another = buildString2 {
        append("Hello, ")// para lambda com recptor pode omitir o it
        append("Higor! ")
    }
    println(another)
}
