package br.com.zup.aluno

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.*

@Introspected
data class NovoAlunoRequest(
    @field:NotBlank @field:Size(max = 60)
    val nome: String,

    @field:Email @field:Size(max = 42)
    val email: String,

    @field:Min(18)
    val idade: Int
) {

}
