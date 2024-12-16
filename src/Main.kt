package Hotel

fun main()
{
    val nomeHotel = "Hotel Terabitia"
    val senhaCorreta = 2678

    println("Bem-vindo ao $nomeHotel!")
    println("Por favor, insira seu nome:")
    val nomeUsuario = readlnOrNull() ?: "Usuário"

    while (true)
    {
        println("Por favor, insira sua senha para acessar o sistema:")
        val senha = readlnOrNull()?.toIntOrNull()

        if (senha == senhaCorreta)
        {
            println("Bem-vindo ao $nomeHotel, $nomeUsuario. É um imenso prazer ter você por aqui!")
            inicio(nomeHotel, nomeUsuario)
            break
        }
        else
        {
            println("Senha incorreta. Tente novamente.")
        }
    }
}

fun inicio(nomeHotel: String, nomeUsuario: String)
{
    while (true)
    {
        println("\nMenu do $nomeHotel:")
        println("1 - Reservar quarto (Quantos quartos?)")
        println("2 - Cadastro de hóspedes (Como Soletra)")
        println("3 - Cadastro de hóspedes (Com S ou com Z?)")
        println("4 - Planejamento de eventos (Que horas você pode?)")
        println("5 - Abastecimento de veículos dos hospédes (Álcool ou Gasolinaa?)")
        println("6 - Manutenção dos ar-condicionados (Ar puro, finalmente.)")
        println("7 - Finalizar sistema")
        println("Escolha uma opção:")

        val opcao = readlnOrNull()?.toIntOrNull()

        when (opcao)
        {
            1 -> quantosquartos(nomeHotel, nomeUsuario)
            2 -> cadastroHospedes(nomeUsuario)
            3 -> cadastroHospedes2(nomeUsuario)
            4 -> eventos(nomeUsuario)
            5 -> abastecimento(nomeUsuario)
            6 -> arcondicionado(nomeUsuario)
            7 -> {
            println("Muito obrigado e volte sempre,$nomeUsuario.")
            break }
            else -> erro(nomeHotel)
        }
    }
}

fun erro(nomeHotel: String) {
    println("Opção inválida! Tente novamente.")
}

