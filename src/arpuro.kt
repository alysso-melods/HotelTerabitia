package Hotel

import java.util.*

fun arcondicionado(nomeUsuario: String)
{
    var menorValor = Double.MAX_VALUE
    var nomeEmpresaMenorValor = ""

    do
    {
        println("Qual o nome da empresa?")
        val nomeEmpresa = readlnOrNull() ?: "Empresa não informada"

        println("Qual o valor por aparelho?")
        val valorPorAparelho = readlnOrNull()?.toDoubleOrNull() ?: 0.0

        println("Qual a quantidade de aparelhos?")
        val quantidadeAparelhos = readlnOrNull()?.toIntOrNull() ?: 0

        println("Qual a porcentagem de desconto?")
        val percentualDesconto = readlnOrNull()?.toDoubleOrNull() ?: 0.0

        println("Qual o número mínimo de aparelhos para conseguir o desconto?")
        val minimoAparelhosDesconto = readlnOrNull()?.toIntOrNull() ?: 0

        val valorTotal = valorPorAparelho * quantidadeAparelhos

        val valorComDesconto = if (quantidadeAparelhos >= minimoAparelhosDesconto) {
            valorTotal - (valorTotal * (percentualDesconto / 100))
        }
        else
        {
            valorTotal
        }

        println("O serviço de $nomeEmpresa custará R$ ${"%.2f".format(valorComDesconto)}")

        if (valorComDesconto < menorValor)
        {
            menorValor = valorComDesconto
            nomeEmpresaMenorValor = nomeEmpresa
        }

        println("Deseja informar novos dados, $nomeUsuario? (S/N)")
        val resposta = readlnOrNull()?.uppercase(Locale.getDefault())

    } while (resposta == "S")

    println("O orçamento de menor valor é o de $nomeEmpresaMenorValor por R$ ${"%.2f".format(menorValor)}")
}

fun main()
{
    println("Qual seu nome?")
    val nomeUsuario = readlnOrNull() ?: "Usuário"
    arcondicionado(nomeUsuario)
}
