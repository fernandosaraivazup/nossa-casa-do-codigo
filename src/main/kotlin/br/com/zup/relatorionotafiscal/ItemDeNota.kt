package br.com.zup.relatorionotafiscal

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_nf_item")
class ItemDeNota(
    val valor: BigDecimal,
    val quantidade: Int
) {
    @Id
    @GeneratedValue
    val id: Long? = null

    val criadaEm: LocalDateTime = LocalDateTime.now()
}
