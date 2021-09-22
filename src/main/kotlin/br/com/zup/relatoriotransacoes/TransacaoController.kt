package br.com.zup.relatoriotransacoes

import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import javax.validation.Valid

@Validated
@Controller("/api/transacoes")
class TransacaoController(val transacaoRepository: TransacaoRepository) {

    var logger = LoggerFactory.getLogger(this.javaClass)

    @Post
    fun cadastraTransacao(@Body @Valid request: NovaTransacaoRequest): HttpResponse<NovaTransacaoResponse> {
        val novaTransacao = request.paraTransacao()

        transacaoRepository.save(novaTransacao)

        val response: NovaTransacaoResponse = NovaTransacaoResponse(novaTransacao)
        logger.info("Nova TRANSAÇÂO cadastrada: ${response}")

        var uri = UriBuilder.of("/api/transacoes/{id}")
            .expand(mutableMapOf(Pair("id", novaTransacao.id)))

        return HttpResponse.created(uri)
    }

    @Get("/{id}")
    fun lista(@PathVariable id: Long): List<TransacaoResponseParaMobile> {
        val ultimos30Dias = LocalDateTime.now().minusDays(30)
        val transacoesCadastradas = transacaoRepository.findByClienteIdAndCriadaEmGreaterThanEqualsOrderByCriadaEmDesc(
                id,
                ultimos30Dias,
                Pageable.from(0, 3))

        val transacoesResponse = transacoesCadastradas.map { transacoesCadastradas ->
                TransacaoResponseParaMobile(transacoesCadastradas.descricao, transacoesCadastradas.valor, transacoesCadastradas.criadaEm) }

        return transacoesResponse
    }
}