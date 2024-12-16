package Hotel

fun quantosquartos(nomeHotel: String, nomeUsuario: String)
{
    val quartos = MutableList(20) { "Livre" }

    while (true)
    {
        println("Bem-vindo ao $nomeHotel!")
        println("Qual o valor padrão da diária?")

        val diaria = readlnOrNull()?.toDoubleOrNull()
        if (diaria == null || diaria <= 0)
        {
            println("ERRO: Valor inválido")
            continue
        }

        println("Quantas diárias serão necessárias?")
        val diarias = readlnOrNull()?.toIntOrNull()
        if (diarias == null || diarias <= 0 || diarias > 30)
        {
            println("ERRO: Valor inválido")
            continue
        }

        val valorTotal = diaria * diarias
        println("O valor de $diarias dias de hospedagem é de R$$valorTotal")

        println("Qual o nome do hóspede?")
        val nomeHospede = readlnOrNull() ?: "Hóspede"

        var quartoSelecionado: Int? = null
        while (true)
        {
            println("Qual o quarto para reserva? (1 - 20)?")
            quartoSelecionado = readlnOrNull()?.toIntOrNull()

            if (quartoSelecionado == null || quartoSelecionado !in 1..20)
            {
                println("ERRO: Número de quarto inválido.")
                continue
            }

            if (quartos[quartoSelecionado - 1] == "Livre")
            {
                println("Quarto livre.")
                break
            }
            else
            {
                println("Quarto ocupado. Escolha outro.")
                exibirQuartos(quartos)
            }
        }

        println("$nomeUsuario, você confirma a hospedagem para $nomeHospede por $diarias dias para o quarto $quartoSelecionado por R$$valorTotal? S/N")
        val confirmacao = readlnOrNull()?.uppercase()

        if (confirmacao == "S")
        {
            if (quartoSelecionado != null)
            {
                quartos[quartoSelecionado - 1] = "Ocupado"
            }
            println("Reserva efetuada para $nomeHospede.")
        }
        else
        {
            println("Reserva não confirmada.")
        }

        exibirQuartos(quartos)

        println("Deseja realizar outra reserva? S/N")
        val outraReserva = readlnOrNull()?.uppercase()
        if (outraReserva == "N")
        {
            println("Obrigado por utilizar o sistema do $nomeHotel. Volte sempre! :) S2")
            break
        }
    }
}

fun exibirQuartos(quartos: List<String>) {
    println("\nLista de quartos (livres e ocupados)")
    quartos.forEachIndexed{ index, status ->
        println("${index + 1} - $status")
    }
}