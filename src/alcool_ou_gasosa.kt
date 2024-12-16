package Hotel

fun abastecimento(nomeUsuario: String) {
    println("Qual o valor do álcool no posto Wayne Oil?")
    val alcoolWayne = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    println("Qual o valor da gasolina no posto Wayne Oil?")
    val gasolinaWayne = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    println("Qual o valor do álcool no posto Stark Petrol?")
    val alcoolStark = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    println("Qual o valor da gasolina no posto Stark Petrol?")
    val gasolinaStark = readlnOrNull()?.toDoubleOrNull() ?: 0.0

    val volumeTanque = 42.0

    val custoAlcoolWayne = alcoolWayne * volumeTanque
    val custoGasolinaWayne = gasolinaWayne * volumeTanque
    val custoAlcoolStark = alcoolStark * volumeTanque
    val custoGasolinaStark = gasolinaStark * volumeTanque

    val precoAlcoolWayne = alcoolWayne * 0.7
    val precoGasolinaWayne = gasolinaWayne
    val precoAlcoolStark = alcoolStark * 0.7
    val precoGasolinaStark = gasolinaStark

    if (precoAlcoolWayne < precoGasolinaWayne && precoAlcoolWayne < precoAlcoolStark && precoAlcoolWayne < precoGasolinaStark) {
        println("$nomeUsuario, é mais barato abastecer com Álcool no posto Wayne Oil")
    } else if (precoGasolinaWayne < precoGasolinaStark && precoGasolinaWayne < precoAlcoolStark) {
        println("$nomeUsuario, é mais barato abastecer com Gasolina no posto Wayne Oil")
    } else if (precoGasolinaStark < precoGasolinaWayne && precoGasolinaStark < precoAlcoolWayne) {
        println("$nomeUsuario, é mais barato abastecer com Gasolina no posto Stark Petrol")
    } else if (precoAlcoolStark < precoAlcoolWayne && precoAlcoolStark < precoGasolinaWayne) {
        println("$nomeUsuario, é mais barato abastecer com Álcool no posto Stark Petrol")
    }
}
