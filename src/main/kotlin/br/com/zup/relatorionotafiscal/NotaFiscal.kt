package br.com.zup.relatorionotafiscal

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class NotaFiscal(
    val numero: String,
    val serie: String,
    val data: LocalDate,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "nota_fiscal_id")
    val itens: List<ItemDeNota>
) {

    @Id
    @GeneratedValue
    val id: Long? = null

    val criadaEm: LocalDateTime = LocalDateTime.now()
}
