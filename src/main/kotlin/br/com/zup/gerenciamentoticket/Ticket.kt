package br.com.zup.gerenciamentoticket

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.PastOrPresent

@Entity
@Table(name = "tb_tickets")
class Ticket(

    @Column(nullable=false, length=60)
    val titulo: String,

    @Column(nullable=false, length=4000)
    val descricao: String
) {
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Long? = null

    @NotNull
    @PastOrPresent
    @Column(name = "created_at", nullable=false, updatable=false)
    val criadoEm: LocalDateTime = LocalDateTime.now()

    @Column(nullable=false)
    @field:Enumerated(EnumType.STRING)
    var status: StatusTicket = StatusTicket.ABERTO
}