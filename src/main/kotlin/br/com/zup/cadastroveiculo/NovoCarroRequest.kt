package br.com.zup.cadastroveiculo

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Introspected
data class NovoCarroRequest(

    @field:Pattern(regexp = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}")
    @field:NotBlank
    val placa: String,

    @field:NotBlank
    @field:Size(max = 60)
    val modelo: String
) {
    fun paraCarro(): Carro {
        return Carro(placa, modelo)
    }
}