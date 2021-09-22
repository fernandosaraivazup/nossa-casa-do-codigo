package br.com.zup.relatoriotransacoes

import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.time.LocalDateTime

@Introspected
data class TransacaoResponseParaMobile(
    val descricao: String,
    val valor: BigDecimal,

    @JsonFormat(pattern = "yyyy/MM/dd")
    val criadaEm: LocalDateTime
) {

    constructor(transacao: Transacao) : this(
        descricao = transacao.descricao,
        valor = transacao.valor,
        criadaEm = transacao.criadaEm
    )
}