package br.com.zup.relatoriotransacoes

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
class NovaTransacaoRequest(

    @field:NotBlank
    val descricao: String,

    @field:NotNull
    val valor: BigDecimal,

    @field:NotNull
    val clienteId: Long,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    val status: StatusDaTransacao

) {
    fun paraTransacao(): Transacao {
        return Transacao(descricao, valor, clienteId, status)
    }
}
