package br.com.zup.cadastroveiculo

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.exceptions.HttpStatusException
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("/api/carros")
class NovoCarroController(val carroRepository: CarroRepository) {

    var logger = LoggerFactory.getLogger(this.javaClass)

    @Post
    fun cadastraCarro(@Body @Valid request: NovoCarroRequest): HttpResponse<NovoCarroResponse> {
        val novoCarro = request.paraCarro()

        if(novoCarro.existeCarroComPlacaInformada(carroRepository)) {
            throw HttpStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "ERRO: já existe um veículo cadastrado com a placa informada!")
        }

        carroRepository.save(novoCarro)

        val response: NovoCarroResponse = NovoCarroResponse(novoCarro)
        logger.info("Novo CARRO cadastrado: ${response}")

        var uri = UriBuilder.of("/api/carros/{id}")
                    .expand(mutableMapOf(Pair("id", novoCarro.id)))

        return HttpResponse.created(uri)

    }
}