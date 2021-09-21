package br.com.zup.autor

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.PastOrPresent

@Entity
@Table(name = "tb_books")
class Livro (
    @Column(name = "title")
    val titulo: String,

    val isbn: String
) {
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Long? = null

    @NotNull
    @PastOrPresent
    @Column(name = "created_at", nullable=false, updatable=false)
    val publicadoEm: LocalDateTime = LocalDateTime.now()
}