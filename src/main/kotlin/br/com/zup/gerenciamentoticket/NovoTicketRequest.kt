package br.com.zup.gerenciamentoticket

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
class NovoTicketRequest (
    @field:NotBlank
    @field:Size(max = 60)
    val titulo: String,

    @field:NotBlank
    @field:Size(max = 4000)
    val descricao: String
) {
    fun paraTicket(): Ticket {
        return Ticket(titulo, descricao)
    }
}
