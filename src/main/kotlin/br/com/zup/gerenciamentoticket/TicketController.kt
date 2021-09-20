package br.com.zup.gerenciamentoticket

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import jakarta.inject.Inject
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("/api/tickets")
class TicketController(@Inject val ticketRepository: TicketRepository) {

    var logger = LoggerFactory.getLogger(this.javaClass)

    @Post
    @Status(HttpStatus.OK)
    fun cria(@Body @Valid request: NovoTicketRequest): Ticket {
        val ticket = request.paraTicket()
        ticketRepository.save(ticket)

        logger.info("Novo TICKET cadastrado: $ticket")
        return ticket
    }

    @Get
    @Status(HttpStatus.OK)
    fun lista(): List<Ticket> {
        val ticketsCadastrados = ticketRepository.findAll()

        return ticketsCadastrados
    }

//    @Put
//    @Status(HttpStatus.OK)
//    fun atualiza(@Body @Valid request: NovoTicketRequest, @PathVariable("id") id: Long): Ticket {
//        val ticketBuscado = ticketRepository.findById(id)
//
//    }

//    @Delete
//    @Status(HttpStatus.OK)
//    fun deleta(@PathVariable("id") id: Long) {
//        val ticketBuscado = ticketRepository.findById(id)
//
//    }
}