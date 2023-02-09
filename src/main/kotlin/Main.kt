fun main(args: Array<String>) {
    val herois = listOf(
        Heroi("Super Man", "Pesado", 120, 0, 0, 0),
        Heroi("Batmam Dark", "Médio", 90, 0, 0, 0),
        Heroi("Homem Aranha", "Leve", 80, 0, 0, 0),
        Heroi("Lanterna Verde", "Médio", 100, 0, 0, 0)
    )

    val viloes = listOf(
        Vilao("Coringa", "Leve", 80, 0, 0, 0),
        Vilao("Lex Lutor", "Pesado", 120, 0, 0, 0),
        Vilao("Duende Verde", "Médio", 90, 0, 0, 0),
        Vilao("Pinguin", "Médio", 100, 0, 0, 0)
    )


    val UEC01 = Luta()
    UEC01.opcoesPersonagensHeroi(herois[0], herois[1], herois[2], herois[3])
    UEC01.opcoesPersonagensVilao(viloes[0], viloes[1], viloes[2], viloes[3])
    UEC01.luta()
}

