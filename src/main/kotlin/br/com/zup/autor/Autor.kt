package br.com.zup.autor

import javax.persistence.*

@Entity
@Table(name = "tb_authors")
class Autor(
    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long,

    @Column(name = "name")
    val nome: String,

    @Column(name = "email")
    val email: String
) {

}