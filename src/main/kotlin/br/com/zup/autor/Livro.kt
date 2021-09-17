package br.com.zup.autor

import javax.persistence.*

@Entity
@Table(name = "tb_books")
class Livro (
    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long,

    @Column(name = "name")
    val nome: String,

    @Column(name = "email")
    val email: String
)