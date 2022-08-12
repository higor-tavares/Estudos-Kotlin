import org.junit.jupiter.api.Test

data class Person(val name:String, val age: Int? = null)

class Capitulo10 {

    @Test
    fun testeReflection(){
        val person = Person(name = "Higor", age = 26)
        val kClass = person.javaClass
        println(kClass.simpleName)
        kClass.declaredFields.forEach {println(it.name)}
    }
    @Test
    fun testeCallable(){
        val kFunction = ::foo
        kFunction.call(42)
    }

    fun foo(x:Int) = println("Your number is $x")
}