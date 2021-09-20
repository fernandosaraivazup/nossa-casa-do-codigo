package br.com.zup.autor

import javax.persistence.*

@Entity
@Table(name = "tb_authors")
class Autor(
    @Column(name = "name")
    val nome: String,

    @Column(name = "email")
    val email: String
) {
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Long? = null
}