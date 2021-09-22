package br.com.zup.relatoriotransacoes

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_transactions")
class Transacao(

    val descricao: String,
    val valor: BigDecimal,
    val clienteId: Long,

    @Enumerated(EnumType.STRING)
    val status: StatusDaTransacao
) {
    @Id
    @GeneratedValue
    val id: Long? = null

    val criadaEm: LocalDateTime = LocalDateTime.now()

    fun paraTransacaoResponse(): NovaTransacaoResponse {
        return NovaTransacaoResponse(descricao, valor, criadaEm)
    }
}
