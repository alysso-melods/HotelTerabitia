package Hotel

fun cadastroHospedes2(nomeUsuario: String)
{
    val listaHospedes = mutableListOf<String>()
    val limiteCadastros = 15

    while (true)
    {
        println("\nMenu de Cadastro e Pesquisa:")
        println("1 - Cadastrar hóspede")
        println("2 - Pesquisar hóspede")
        println("3 - Listar hóspedes")
        println("4 - Sair")
        println("Selecione uma opção:")

        val opcao = readlnOrNull()?.toIntOrNull()

        when (opcao)
        {
            1 -> {
                if (listaHospedes.size >= limiteCadastros)
                {
                    println("Máximo de cadastros atingido.")
                }
                else
                {
                    println("Qual o nome do hóspede?")
                    val nomeHospede = readlnOrNull()?.trim() ?: ""

                    if (nomeHospede.isNotEmpty())
                    {
                        listaHospedes.add(nomeHospede)
                        println("Hóspede $nomeHospede foi cadastrada(o) com sucesso!")
                    }
                    else
                    {
                        println("ERRO: Nome inválido. Tente novamente.")
                    }
                }
            }

            2 -> {
                println("Qual o nome do hóspede que deseja pesquisar?")
                val nomePesquisa = readlnOrNull()?.trim() ?: ""
                if (listaHospedes.contains(nomePesquisa))
                {
                    println("Hóspede $nomePesquisa foi encontrada(o)")
                }
                else
                {
                    println("Hóspede $nomePesquisa não foi encontrada(o)")
                }
            }

            3 -> {
                if (listaHospedes.isEmpty())
                {
                    println("Nenhum hóspede cadastrado.")
                }
                else
                {
                    println("Lista de hóspedes:")
                    listaHospedes.forEachIndexed { index, hospede -> println("${index + 1}. $hospede") }
                }
            }
            4 -> {
                println("Retornando ao menu principal")
                break
            }
            else -> {
                println("Opção inválida! Tente novamente.")
            }
        }
    }
}

