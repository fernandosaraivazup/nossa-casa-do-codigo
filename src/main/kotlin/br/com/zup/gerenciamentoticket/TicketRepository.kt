package br.com.zup.gerenciamentoticket

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface TicketRepository: JpaRepository<Ticket, Long> {
}