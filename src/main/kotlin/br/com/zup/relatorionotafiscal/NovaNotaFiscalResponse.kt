package br.com.zup.relatorionotafiscal

import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate

@Introspected
data class NovaNotaFiscalResponse(
    val numero: String,
    val serie: String,

    @JsonFormat(pattern = "yyy-MM-dd")
    val data: LocalDate,

    val itens: List<ItemDeNotaResponse>
) {

    constructor(notaFiscal: NotaFiscal): this (
        numero = notaFiscal.numero,
        serie = notaFiscal.serie,
        data = notaFiscal.data,
        itens = notaFiscal.itens.map { itens -> ItemDeNotaResponse(itens.valor, itens.quantidade) }
    )

    override fun toString(): String {
        return "NovaNotaFiscalResponse(numero='$numero', serie='$serie', data=$data, itens=$itens)"
    }
}
