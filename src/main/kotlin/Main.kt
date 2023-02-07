fun main(args: Array<String>) {
    val l = arrayOfNulls<Heroi>(3)
    l[0] = Heroi("Super Man", "Pesado", 120, 0, 0, 0)
    l[1] = Heroi("Batmam Dark", "Médio", 90, 0, 0, 0)
    l[2] = Heroi("Homem Aranha", "Leve", 80, 0, 0, 0)
    val o = arrayOfNulls<Vilao>(3)
    o[0] = Vilao("Coringa", "Leve", 80, 0, 0, 0)
    o[1] = Vilao("Lex Lutor", "Pesado", 100, 0, 0, 0)
    o[2] = Vilao("Duende Verde", "Médio", 90, 0, 0, 0)

    val UEC01 = Luta()
    UEC01.opcoesPersonagensHeroi(l[0]!!, l[1]!!, l[2]!!)
    UEC01.opcoesPersonagensVilao(o[0]!!, o[1]!!, o[2]!!)
    UEC01.luta()
}
