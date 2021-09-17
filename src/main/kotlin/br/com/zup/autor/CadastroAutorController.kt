package br.com.zup.autor

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status
import org.slf4j.LoggerFactory

@Controller("/api/autores")
class CadastroAutorController {

    var logger= LoggerFactory.getLogger(this.javaClass)

    @Post
    @Status(HttpStatus.CREATED)
    fun cadastra(@Body request: NovoAutorRequest) {
        logger.info("Novo AUTOR cadastrado: $request")
    }

}