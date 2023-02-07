enum class IntensidadeAtaque {
    ATAQUE_FRACO, ATAQUE_FORTE, ATAQUE_CRITICO, DEFESA;

    companion object {
        fun converterOpcao(numero: Int): IntensidadeAtaque {
            return when (numero) {
                1 -> ATAQUE_FRACO
                2 -> ATAQUE_FORTE
                3 -> ATAQUE_CRITICO
                else -> DEFESA
            }
        }
    }
}