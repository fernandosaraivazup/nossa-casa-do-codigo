package br.com.zup.finalizacaocompra

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.*

@Introspected
data class NovoPedidoRequest(

    @field:NotBlank
    val nome: String,

    @field:NotBlank
    @field:Email
    val email: String,

    @field:Size(min = 1)
    val itens: List<ItemDePedidoRequest>
) {
    fun paraPedido(): Pedido {
        return Pedido(
            Cliente(nome, email), BigDecimal(1000), itens.map { ItemDePedido(it.codigo, it.preco, it.quantidade) }
        )
    }
}
