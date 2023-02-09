class Luta {
    private var escolhaHeroi: Heroi? = null
    private var escolhaVilao: Vilao? = null
    private var escolhaRounds = 0
    private var numeroGolpeHeroi: IntensidadeAtaque? = null
    private var numeroGolpeVilao: IntensidadeAtaque? = null
    private var ataqueHeroi = 0
    private var ataqueVilao = 0
    private var defesaHeroi = false
    private var defesaVilao = false

    fun opcoesPersonagensHeroi(h1: Heroi, h2: Heroi, h3: Heroi, h4: Heroi) {
        println(" -------------------------------")
        println("|        JOGO DOS HEROIS       |")
        println(" -------------------------------")
        for (contador in 1..4) {
            println("[$contador] ")
            when (contador) {
                1 -> h1.apresentar()
                2 -> h2.apresentar()
                3 -> h3.apresentar()
                4 -> h4.apresentar()
                else -> {}
            }
        }
        println("--------------------------------")
        println("  QUAL HEROI VOCÊ ESCOLHE ?")
        print("---> ")
        when (readLine()!!.toInt()) {
            1 -> {
                escolhaHeroi = h1
            }

            2 -> {
                escolhaHeroi = h2
            }

            3 -> {
                escolhaHeroi = h3
            }
            4 -> {
                escolhaHeroi = h4
            }
        }
    }

    fun opcoesPersonagensVilao(v1: Vilao, v2: Vilao, v3: Vilao, v4: Vilao) {
        println("O COMPUTADOR VAI ESCOLHER O SEU OPONENTE !")
        val randomm = (0..3).random()
        when (randomm + 1) {
            1 -> {
                escolhaVilao = v1
            }

            2 -> {
                escolhaVilao = v2
            }

            3 -> {
                escolhaVilao = v3
            }
            4 -> {
                escolhaVilao = v4
            }
        }
    }

    private fun rounds() {
        println("Quantos Hound deseja jogar ?")
        print("---> ")
        escolhaRounds = readLine()!!.toInt()
    }

    private fun apresentacao() {
        println("Escolhendo aleatoriamente o campo...")
        println("PREPARANDO CAMPO DE BATALHA")
        println("")
        println("|===================================|")
        println("    ${escolhaHeroi?.nome} X ${escolhaVilao?.nome} ")
        println("|===================================| ")
        println(" Vida ${escolhaHeroi?.vida}           Vida  ${escolhaVilao?.vida}   %")
        println(" Categoria ${escolhaHeroi?.categoria}  Categoria  ${escolhaVilao?.categoria}()")
        println("_____________________________________")
        println("SERÁ UM PARTIDA DE $escolhaRounds hounds.")
        println("O campo escolhido aleatoriamente foi...")
        println("Campo de gelo.")
        println("_____________________________________")
        println("")
    }

    private fun escolhaAtaqueHeroi() {
        println("==================================")
        println(
            "[1] ATAQUE FRACO \n" +
                    "[2] ATAQUE FORTE\n" +
                    "[3] ATAQUE CRITICO\n" +
                    "[4] DEFESA \n"
        )
        println("==================================")
        println("= QUAL O SEU COMANDO ?           =")
        print("=   -----> ")
        val escolha = readLine()!!.toInt()
        numeroGolpeHeroi = IntensidadeAtaque.converterOpcao(escolha)
        println("==================================")
        println(numeroGolpeHeroi)
    }

    private fun escolhaAtaqueVilao() {
        val aleatorio = (0..2).random()
        val escolha = aleatorio + 1
        numeroGolpeVilao = IntensidadeAtaque.converterOpcao(escolha)
        println(numeroGolpeVilao)
    }

    private fun danoHeroi() {
        if (null == numeroGolpeHeroi) {
            println("ERRO")
        } else {
            when (numeroGolpeHeroi) {
                IntensidadeAtaque.ATAQUE_FRACO -> ataqueHeroi = when (escolhaHeroi?.categoria) {
                    "Leve" -> 30
                    "Médio" -> 20
                    else -> 10
                }

                IntensidadeAtaque.ATAQUE_FORTE -> ataqueHeroi = when (escolhaHeroi?.categoria) {
                    "Leve" -> 40
                    "Médio" -> 30
                    else -> 20
                }

                IntensidadeAtaque.ATAQUE_CRITICO -> ataqueHeroi = when (escolhaHeroi?.categoria) {
                    "Leve" -> 50
                    "Médio" -> 40
                    else -> 30
                }

                IntensidadeAtaque.DEFESA -> {
                    if (numeroGolpeHeroi === IntensidadeAtaque.DEFESA && numeroGolpeVilao === IntensidadeAtaque.DEFESA) {
                        println("Os dois se defenderam")
                        defesaHeroi = true
                        defesaVilao = true
                    } else if (numeroGolpeHeroi === IntensidadeAtaque.DEFESA && numeroGolpeVilao !== IntensidadeAtaque.DEFESA) {
                        escolhaVilao?.vida = (escolhaVilao?.vida?.minus(ataqueVilao)!!)
                        println("O  ${escolhaVilao?.nome}  recebeu  $ataqueVilao  de dano porque o  ${escolhaHeroi?.nome}  se defendeu")
                        defesaHeroi = true
                    } else if (numeroGolpeHeroi !== IntensidadeAtaque.DEFESA && numeroGolpeVilao === IntensidadeAtaque.DEFESA) {
                        escolhaHeroi?.vida = (escolhaHeroi?.vida?.minus(ataqueHeroi)!!)
                        println("O " + escolhaHeroi?.nome + " recebeu " + ataqueHeroi + " de dano porque o " + escolhaVilao?.nome + " se defendeu")
                        defesaVilao = true
                    }
                }

                else -> println("ERRO")
            }
        }
    }

    private fun danoVilao() {
        if (null == numeroGolpeVilao) {
            println("ERRO")
        } else {
            when (numeroGolpeVilao) {
                IntensidadeAtaque.ATAQUE_FRACO -> ataqueVilao = when (escolhaVilao?.categoria) {
                    "Leve" -> 10
                    "Médio" -> 20
                    else -> 30
                }

                IntensidadeAtaque.ATAQUE_FORTE -> ataqueVilao = when (escolhaVilao?.categoria) {
                    "Leve" -> 10
                    "Médio" -> 20
                    else -> 40
                }

                IntensidadeAtaque.ATAQUE_CRITICO -> ataqueVilao = when (escolhaVilao?.categoria) {
                    "Leve" -> 10
                    "Médio" -> 20
                    else -> 50
                }

                IntensidadeAtaque.DEFESA -> {
                    if (numeroGolpeHeroi === IntensidadeAtaque.DEFESA && numeroGolpeVilao === IntensidadeAtaque.DEFESA) {
                        println("Os dois se defenderam")
                        defesaHeroi = true
                        defesaVilao = true
                    } else if (numeroGolpeHeroi === IntensidadeAtaque.DEFESA && numeroGolpeVilao !== IntensidadeAtaque.DEFESA) {
                        escolhaVilao?.vida = (escolhaVilao?.vida!! - ataqueVilao)
                        println("O " + escolhaVilao?.nome + " recebeu " + ataqueVilao + " de dano porque o " + escolhaHeroi?.nome + " se defendeu")
                        defesaHeroi = true
                    } else if (numeroGolpeHeroi !== IntensidadeAtaque.DEFESA && numeroGolpeVilao === IntensidadeAtaque.DEFESA) {
                        escolhaHeroi?.vida = (escolhaHeroi?.vida!! - ataqueHeroi)
                        println("O " + escolhaHeroi?.nome + " recebeu " + ataqueHeroi + " de dano porque o " + escolhaVilao?.nome + " se defendeu")
                        defesaVilao = true
                    }
                }

                else -> println("ERRO")
            }
        }
    }

    fun luta() {
        rounds()
        apresentacao()
        while (escolhaRounds > 0) {
            escolhaAtaqueHeroi()
            escolhaAtaqueVilao()
            println("")
            if (numeroGolpeHeroi !== IntensidadeAtaque.DEFESA && numeroGolpeVilao !== IntensidadeAtaque.DEFESA) {
                danoHeroi()
                escolhaVilao?.vida = (escolhaVilao!!.vida - ataqueHeroi)
                println("O " + escolhaHeroi!!.nome + " causou " + ataqueHeroi + " de dano no " + escolhaVilao?.nome)
                println("------------------------------------")
                danoVilao()
                escolhaHeroi?.vida = (escolhaHeroi?.vida!! - ataqueVilao)
                println("O " + escolhaVilao?.nome + " causou " + ataqueVilao + " de dano no " + escolhaHeroi?.nome)
                println("------------------------------------")
            } else {
                println("DEFESA !.")
                danoHeroi()
                danoVilao()
            }
            println(escolhaHeroi?.nome + " VIDA: " + escolhaHeroi?.vida)
            println(escolhaVilao?.nome + " VIDA: " + escolhaVilao?.vida)
            if (escolhaHeroi?.vida!! <= 0 || escolhaVilao?.vida!! <= 0) {
                break
            }
            escolhaRounds -= 1
        }
        println("")
        if (escolhaHeroi?.vida!! > escolhaVilao?.vida!!) {
            escolhaHeroi?.ganharLuta()
            escolhaVilao?.perderLuta()
        } else if (escolhaHeroi!!.vida < escolhaVilao?.vida!!) {
            escolhaHeroi?.perderLuta()
            escolhaVilao?.ganharLuta()
        } else {
            escolhaHeroi?.empatarLuta()
            escolhaVilao?.empatarLuta()
        }
        println("")
        println("   STATUS ATUAL ")
        escolhaHeroi?.status()
        println("VIDA " + escolhaHeroi?.nome + " :" + escolhaHeroi?.vida)
        println("")
        escolhaVilao?.status()
        println("VIDA " + escolhaVilao?.nome + " :" + escolhaVilao?.vida)
    }
}
