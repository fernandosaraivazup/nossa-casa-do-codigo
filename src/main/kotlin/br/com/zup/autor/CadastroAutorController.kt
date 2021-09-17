package br.com.zup.autor

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status

@Controller("/api/autores")
class CadastroAutorController {

    @Post
    @Status(HttpStatus.CREATED)
    fun cadastra(@Body request: NovoAutorRequest) {
        println(request)
    }
}