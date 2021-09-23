package br.com.zup.relatorionotafiscal

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface NotaFiscalRepository: JpaRepository<NotaFiscal, Long> {

    //carregar uma nota fiscal por id com todos seus itens para então exibir no aplicativo mobile
    @Query("SELECT nf FROM NotaFiscal nf JOIN FETCH nf.itens i WHERE nf.id = :id")
    fun findByIdPersonalizado(id: Long): Optional<NotaFiscal>
}