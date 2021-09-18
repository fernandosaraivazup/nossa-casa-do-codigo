package br.com.zup.aluno

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status
import jakarta.inject.Inject

import org.slf4j.LoggerFactory
import javax.validation.ConstraintViolationException
import javax.validation.Validator

@Controller("/api/alunos")
class CadastroAlunoController {

    @Inject
    lateinit var validator: Validator

    var logger= LoggerFactory.getLogger(this.javaClass)

    @Post
    @Status(HttpStatus.CREATED)
    fun cadastra(@Body request: NovoAlunoRequest): NovoAlunoRequest {
        val constraintViolations = validator.validate(request)

        if(constraintViolations.isNotEmpty()) {
            throw ConstraintViolationException(constraintViolations)
        }

        logger.info("Novo ALUNO cadastrado: $request")
        return request
    }

}