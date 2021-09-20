package br.com.zup.cadastroveiculo

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.PastOrPresent

@Entity
@Table(name = "tb_cars")
class Carro(

    @Column(name = "car_plate", nullable=false, length=7)
    val placa: String,

    @Column(name = "model", nullable=false, length=60)
    val modelo: String
) {
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Long? = null

    @NotNull
    @PastOrPresent
    @Column(name = "created_at", nullable=false, updatable=false)
    val criadoEm: LocalDateTime = LocalDateTime.now()

    fun existeCarroComPlacaInformada(carroRepository: CarroRepository): Boolean {
        if(carroRepository.findByPlaca(placa).isEmpty) {
            return false
        }
        return true
    }
}