package br.com.zup.finalizacaocompra

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Introspected
data class ItemDePedidoRequest(
    @field:NotBlank
    val codigo: String,

    @field:NotNull
    @field:Positive
    val preco: BigDecimal,

    @field:NotNull
    @field:Positive
    val quantidade: Int
) {
    fun getTotal(): BigDecimal {
        //iterar pela lista de items somando o valor total (preco * quantidade) de cada item do pedido
        return preco * BigDecimal(quantidade)
    }
}
