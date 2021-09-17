package br.com.zup.autor

data class NovoAutorRequest(
    val nome: String,
    val email: String,
    val livros: List<LivroRequest>
) {

}
