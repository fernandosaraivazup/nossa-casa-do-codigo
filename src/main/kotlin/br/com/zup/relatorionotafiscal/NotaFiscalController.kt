package br.com.zup.relatorionotafiscal

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.http.exceptions.HttpStatusException
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("/api/notasfiscais")
class NotaFiscalController(val notaFiscalRepository: NotaFiscalRepository) {

    var logger = LoggerFactory.getLogger(this.javaClass)

    @Post
    fun cadastraNota(@Body @Valid request: NovaNotaFiscalRequest): HttpResponse<NovaNotaFiscalResponse> {

        val novaNotaFiscal = request.paraNotaFiscal()

        notaFiscalRepository.save(novaNotaFiscal)

        val response: NovaNotaFiscalResponse = NovaNotaFiscalResponse(novaNotaFiscal)
        logger.info("Nova NF cadastrada: ${response}")

        var uri = UriBuilder.of("/api/notasfiscais/{id}")
            .expand(mutableMapOf(Pair("id", novaNotaFiscal.id)))

        return HttpResponse.created(uri)
    }

    @Get("/{id}")
    fun lista(@PathVariable id: Long): NotaFiscalMobileResponse {
        val notaFiscalBuscada = notaFiscalRepository.findByIdPersonalizado(id)

        if(notaFiscalBuscada.isEmpty) {
            throw HttpStatusException(HttpStatus.NOT_FOUND, "NF com o ID informado não encontrada!")
        }

        val nota = notaFiscalBuscada.get()

        val response = NotaFiscalMobileResponse(nota)

        return response
    }
}
