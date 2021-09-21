package br.com.zup.autor

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("/api/autores")
class CadastroAutorController(val autorRepository: AutorRepository) {

    var logger= LoggerFactory.getLogger(this.javaClass)

    @Post
    fun cadastra(@Body @Valid request: NovoAutorRequest): HttpResponse<NovoAutorResponse> {
        val novoAutor = request.paraAutor()

        autorRepository.save(novoAutor)

        val response: NovoAutorResponse = NovoAutorResponse(novoAutor)
        logger.info("Novo AUTOR cadastrado: $response")

        var uri = UriBuilder.of("/api/autores/{id}")
            .expand(mutableMapOf(Pair("id", novoAutor.id)))

        return HttpResponse.created(uri)
    }

    @Put("/{id}")
    fun atualiza(@PathVariable id: Long, @Body request: AtualizaAutorRequest): HttpResponse<Any> {
        val autorBuscado = autorRepository.findById(id)

        if(autorBuscado.isEmpty) {
            return HttpResponse.notFound()
        }

        val autor = autorBuscado.get()

        autor.nome = request.nome
        autor.email = request.email

        autorRepository.update(autor)

        return HttpResponse.ok(NovoAutorResponse(autor))
    }
}