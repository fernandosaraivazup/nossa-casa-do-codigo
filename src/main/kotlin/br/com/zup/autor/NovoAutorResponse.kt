package br.com.zup.autor

class NovoAutorResponse(
    autor: Autor
) {
    val nome = autor.nome
    val email = autor.email

    override fun toString(): String {
        return "NovoAutorResponse(nome='$nome', email='$email')"
    }
}
