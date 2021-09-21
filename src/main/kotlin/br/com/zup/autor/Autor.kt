package br.com.zup.autor

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.PastOrPresent

@Entity
@Table(name = "tb_authors")
class Autor(
    @Column(name = "name")
    var nome: String,

    @Column(name = "email")
    var email: String
) {
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Long? = null

    @NotNull
    @PastOrPresent
    @Column(name = "created_at", nullable=false, updatable=false)
    val criadoEm: LocalDateTime = LocalDateTime.now()

    override fun toString(): String {
        return "Autor(nome='$nome', email='$email', id=$id, criadoEm=$criadoEm)"
    }
}