package html
// Criando uma DSL para criação de HTML

open class Tag(val name: String) {
    private val children = mutableListOf<Tag>()
    protected fun <T: Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }
    override  fun toString() = "<$name>${children.joinToString("")}</$name>"
}

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)
}
class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}
class TD : Tag("td")

fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

fun createTable() =
    table {
        tr {
            td {

            }
        }
    }

fun main(args : Array<String>) {
    println(createTable())
}