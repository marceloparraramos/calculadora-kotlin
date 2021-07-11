const val SUM = 1
const val SUBTRACTION = 2
const val MULTIPLICATION = 3
const val DIVISION = 4
const val EXIT = 5

fun sum(x: Float, y: Float): Float = x + y

fun subtract(x: Float, y: Float): Float = x - y

fun multiplication(x: Float, y: Float): Float = x * y

fun division(x: Float, y: Float): Float = x / y

fun calculate(operation: Int): Float? {
    print("Digite o primeiro valor: ")
    val x: Float? = readLine()?.toFloatOrNull()
    print("Digite o segundo valor: ")
    val y: Float? = readLine()?.toFloatOrNull()

    var result: Float? = null

    if (x == null || y == null) {
        println("Você deve digitar dois números!")
    } else {
        when (operation) {
            SUM -> result = sum(x, y)
            SUBTRACTION -> result = subtract(x, y)
            MULTIPLICATION -> result = multiplication(x, y)
            DIVISION -> result = division(x, y)
            else -> println("Operação inválida")
        }
    }
    return result
}

fun main(args: Array<String>) {
    while (true) {
        println("Escolha uma operação:")
        println("$SUM - Adição")
        println("$SUBTRACTION - Subtração")
        println("$MULTIPLICATION - Multiplicação")
        println("$DIVISION - Divisão")
        println("$EXIT - Sair")

        val operationStr = readLine()
        var operation: Int? = null

        if (operationStr != null && operationStr.isNotEmpty()) {
            operation = operationStr.toInt()
        }

        if (operation == null || operation !in SUM..EXIT) {
            println("Operação inválida")
        } else if (operation == EXIT) {
            break
        } else {
            val result = calculate(operation)
            val message = result ?: "Resultado inválido!"
            println(message)
        }
    }
}