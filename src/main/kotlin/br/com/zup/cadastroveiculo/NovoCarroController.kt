package br.com.zup.cadastroveiculo

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status
import io.micronaut.http.exceptions.HttpStatusException
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("/api/carros")
class NovoCarroController(val carroRepository: CarroRepository) {

    var logger = LoggerFactory.getLogger(this.javaClass)

    @Post
    @Status(HttpStatus.CREATED)
    fun cadastraCarro(@Body @Valid request: NovoCarroRequest): NovoCarroRequest {
        val novoCarro = request.paraCarro()

        if(novoCarro.existeCarroComPlacaInformada(carroRepository)) {
            throw HttpStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "ERRO: já existe um veículo cadastrado com a placa informada!")
        }

        carroRepository.save(novoCarro)

        logger.info("Novo CARRO cadastrado: $request")
        return request
    }
}