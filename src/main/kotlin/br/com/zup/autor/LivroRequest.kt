package br.com.zup.autor

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class LivroRequest (
    val titulo: String,
    val isbn: String,
    @JsonFormat(pattern = "yyyy-MM-dd")
    val publicadoEm: LocalDate
) {

}
