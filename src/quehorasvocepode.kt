package Hotel

fun eventos(nomeUsuario: String)
{
    println("Qual o número de convidados para o seu evento?")
    val convidados = readlnOrNull()?.toIntOrNull() ?: -1
    if (convidados <= 0 || convidados > 350)
    {
        println("Número de convidados inválido")
    }
    else
    {
        if (convidados <= 220)
        {
            println("Use o auditório Laranja")
            val cadeirasAdicionais = if (convidados > 150) convidados - 150 else 0
            if (cadeirasAdicionais > 0)
            {
                println(" (inclua mais $cadeirasAdicionais cadeiras)")
            }
        }
        else
        {
            println("Use o auditório Colorado")
        }
        println("Agora vamos ver a agenda do evento.")
    }

    println("Qual o dia do seu evento? (segunda a domingo)")
    val dia = readlnOrNull()?.toLowerCase()
    println("Qual a hora do seu evento?")
    val hora = readlnOrNull()?.toIntOrNull() ?: -1

    val horarioDisponivel = when (dia)
    {
        "segunda", "terca", "quarta", "quinta", "sexta" -> hora in 7..23
        "sabado", "domingo" -> hora in 7..15
        else -> false
    }

    if (horarioDisponivel)
    {
        println("Qual o nome da empresa?")
        val empresa = readlnOrNull() ?: "Empresa não informada"
        println("Auditório reservado para $empresa. $dia às ${hora}hs.")
    }
    else
    {
        println("Auditório indisponível")
    }

    println("Qual a duração do evento em horas?")
    val duracaoEvento = readlnOrNull()?.toIntOrNull() ?: 0
    val garconsNecessarios = (convidados + 11) / 12 + (duracaoEvento + 1) / 2
    val custoGarcons = garconsNecessarios * 10.50 * duracaoEvento

    println("São necessários $garconsNecessarios garçons.")
    println("Custo: R$ $custoGarcons")
    println("Agora vamos calcular o buffet do hotel para o evento.")
    println("O evento precisará de ${0.2 * convidados} litros de café, ${0.5 * convidados} litros de água, ${7 * convidados} salgados.")

    val custoBuffet = (0.2 * convidados * 0.80) + (0.5 * convidados * 0.40) + (convidados / 100 * 34)
    println("Custo do Buffet: R$ $custoBuffet")

    val valorTotal = custoGarcons + custoBuffet
    println("Valor total do Evento: R$ $valorTotal")

    println("Gostaria de efetuar a reserva? S/N")
    val resposta = readlnOrNull()

    if (resposta == "S" || resposta == "s")
    {
        println("Reserva efetuada com sucesso.")
    }
    else
    {
        println("Reserva não efetuada.")
    }
}
