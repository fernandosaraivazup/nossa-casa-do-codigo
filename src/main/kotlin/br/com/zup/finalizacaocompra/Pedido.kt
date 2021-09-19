package br.com.zup.finalizacaocompra

import java.math.BigDecimal

class Pedido(
    val cliente: Cliente,
    val total: BigDecimal,
    val itens: List<ItemDePedido>
) {

}
