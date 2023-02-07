open class Personagem(
    var nome: String, var categoria: String,
    var vida: Int, var vit: Int, var de: Int, var em: Int
) {

    var vitorias: Int
    var derrotas: Int
    var empates: Int

    init {
        vida = vida
        vitorias = vit
        derrotas = de
        empates = em
    }

    fun apresentar() {
        //System.out.println("--------------------------");
        println(nome)
        println("Vida $vida %")
        println("Categoria $categoria")
        //System.out.println("--------------------------");
    }

    fun status() {
        println("$nome é um $categoria")
        println("Ganhou $vitorias vezes")
        println("Perdeu $derrotas vezes")
        println("Empatou $empates vezes")
    }

    fun ganharLuta() {
        vitorias = vitorias + 1
        println("$nome  GANHOU !!!")
    }

    fun perderLuta() {
        derrotas = derrotas + 1
        println("$nome PERDEU !!!")
    }

    fun empatarLuta() {
        empates = empates + 1
        println("EMPATE !!!")
    }

}