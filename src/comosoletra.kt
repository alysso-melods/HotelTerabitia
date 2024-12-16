package Hotel

fun cadastroHospedes(nomeUsuario: String)
{
    println("Bem-vindo ao sistema de cadastro de hóspedes!")

    println("Qual o valor padrão da diária?")
    val diaria = readlnOrNull()?.toDoubleOrNull()
    if (diaria == null || diaria <= 0)
    {
        println("ERRO: Valor inválido. Encerrando o sistema.")
        return
    }

    var gratuidades = 0
    var meiaDiaria = 0
    var valorTotal = 0.0

    while (true)
    {
        println("Qual o nome do hóspede? (Digite 'PARE' para encerrar)")
        val nomeHospede = readlnOrNull() ?: ""

        if (nomeHospede.uppercase() == "PARE")
        {
            println("$nomeUsuario, o valor total das hospedagens é: R$${"%.2f".format(valorTotal)}; " +
                    "$gratuidades gratuidade(s); " +
                    "$meiaDiaria meia(s)")
            break
        }

        println("Qual a idade do hóspede?")
        val idade = readlnOrNull()?.toIntOrNull()

        if (idade == null || idade < 0)
        {
            println("Idade inválida. Tente novamente.")
            continue
        }
        if (idade < 6)
        {
            println("$nomeHospede cadastrado(a) com sucesso. $nomeHospede possui gratuidade.")
            gratuidades++
        }
        else if (idade > 60)
        {
            println("$nomeHospede cadastrado(a) com sucesso. $nomeHospede paga meia.")
            meiaDiaria++
            valorTotal += diaria / 2
        }
        else
        {
            println("$nomeHospede cadastrado(a) com sucesso.")
            valorTotal += diaria
        }
    }
}
