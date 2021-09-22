package br.com.zup.relatoriotransacoes

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.time.LocalDateTime

@Introspected
data class NovaTransacaoResponse(
    val descricao: String,
    val valor: BigDecimal,
    val criadaEm: LocalDateTime
) {

    constructor(transacao: Transacao) : this(
        descricao = transacao.descricao,
        valor = transacao.valor,
        criadaEm = transacao.criadaEm
    )

    override fun toString(): String {
        return "NovaTransacaoResponse(descricao='$descricao', valor=$valor, criadaEm=$criadaEm)"
    }
}
