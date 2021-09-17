package br.com.zup.aluno

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("/api/alunos")
class CadastroAlunoController {

    var logger= LoggerFactory.getLogger(this.javaClass)

    @Post
    @Status(HttpStatus.OK)
    fun cadastra(@Body @Valid request: NovoAlunoRequest) {
        logger.info("Novo ALUNO cadastrado: $request")
    }

}