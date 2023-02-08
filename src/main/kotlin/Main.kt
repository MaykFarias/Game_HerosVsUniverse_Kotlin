fun main(args: Array<String>) {
    val herois = listOf(
        Heroi("Super Man", "Pesado", 120, 0, 0, 0),
        Heroi("Batmam Dark", "Médio", 90, 0, 0, 0),
        Heroi("Homem Aranha", "Leve", 80, 0, 0, 0)
    )

    val vilaos = listOf(
        Vilao("Coringa", "Leve", 80, 0, 0, 0),
        Vilao("Lex Lutor", "Pesado", 100, 0, 0, 0),
        Vilao("Duende Verde", "Médio", 90, 0, 0, 0)
    )


    val UEC01 = Luta()
    UEC01.opcoesPersonagensHeroi(herois[0], herois[1], herois[2])
    UEC01.opcoesPersonagensVilao(vilaos[0], vilaos[1], vilaos[2])
    UEC01.luta()
}

