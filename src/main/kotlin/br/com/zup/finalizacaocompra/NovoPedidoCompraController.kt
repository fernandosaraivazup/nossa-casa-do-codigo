package br.com.zup.finalizacaocompra

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Controller("/api/finalizacompras")
@Validated
class NovoPedidoCompraController {

    var logger= LoggerFactory.getLogger(this.javaClass)

    @Post
    @Status(HttpStatus.OK)
    fun finalizarPedido(@Body @Valid request: NovoPedidoRequest): Pedido {

        val pedido = request.paraPedido()
        logger.info("Novo PEDIDO cadastrado: $request")

        return pedido
    }
}