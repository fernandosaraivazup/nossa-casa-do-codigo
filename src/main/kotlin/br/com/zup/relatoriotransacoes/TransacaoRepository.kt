package br.com.zup.relatoriotransacoes

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.model.Pageable
import java.time.LocalDateTime

@Repository
interface TransacaoRepository : JpaRepository<Transacao, Long> {

    //gerar um relatório das transações de pagamento feitas nos últimos 30 dias pelo cliente
    fun findByClienteIdAndCriadaEmGreaterThanEqualsOrderByCriadaEmDesc(
            clienteId: Long,
            criadaEm: LocalDateTime,
            pageable: Pageable): List<TransacaoResponseParaMobile>
}
