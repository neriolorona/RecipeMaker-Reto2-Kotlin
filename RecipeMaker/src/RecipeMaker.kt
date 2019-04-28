fun main() {

    var exit = false
    var recipe = ""

    do {
        makeMenu()
        var responseMenuApp: String? = readLine()

        when (responseMenuApp?.toInt()) {
            1 -> {
                println("Define un nombre para tu receta")
                var responseName: String? = readLine()
                recipe += "::RECETA::\nNOMBRE: $responseName\n"

                do {
                    println("Agrega ingrediente, selecciona opción:")
                    makeRecipe()
                    var responseIngrediente: String? = readLine()
                    when(responseIngrediente?.toInt()) {
                        1 -> recipe += "Ingrediente: agua\n"
                        2 -> recipe += "Ingrediente: leche\n"
                        3 -> recipe += "Ingrediente: carne\n"
                        4 -> recipe += "Ingrediente: verduras\n"
                        5 -> recipe += "Ingrediente: frutas\n"
                        6 -> recipe += "Ingrediente: cereal\n"
                        7 -> recipe += "Ingrediente: huevos\n"
                        8 -> recipe += "Ingrediente: aceite\n"
                        else -> responseIngrediente = 0.toString()
                    }
                } while (responseIngrediente?.toInt() != 0)
            }
            2 -> {
                viewRecipe(recipe)
            }
            3 -> {
                responseMenuApp = 0.toString()
                exit = true
            }
            else -> {
                println("Tu opción ingresada no es válida!!")
            }
        }
    } while (!exit)
}

fun makeMenu(): Unit {
    println("""
        ::Bienvenido a Recipe Maker::

        Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
    """.trimIndent())
}

fun makeRecipe(): Unit {
    println("""
        ::LISTA DE INGREDIENTES::
        1. agua
        2. leche
        3. carne
        4. verduras
        5. frutas
        6. cereal
        7. huevos
        8. aceite
        0. SALIR
    """.trimIndent())
}

fun viewRecipe(recipe: String): Unit {
    if(recipe.isEmpty()) {
        println("No tienes recetas")
    } else {
        println(recipe)
    }
}