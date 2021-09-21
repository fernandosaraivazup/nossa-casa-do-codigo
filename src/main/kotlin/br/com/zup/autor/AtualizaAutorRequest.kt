package br.com.zup.autor

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
class AtualizaAutorRequest(

    @field:NotBlank
    @field:Size(max = 45)
    val nome: String,

    @field:NotBlank
    @field:Size(max = 60)
    val email: String,
) {

}
