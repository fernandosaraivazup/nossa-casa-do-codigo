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
        val total: BigDecimal = itens.sumOf { it.getTotal() }
        return Pedido(
            Cliente(nome, email), total, itens.map { ItemDePedido(it.codigo, it.preco, it.quantidade) }
        )
    }
}
