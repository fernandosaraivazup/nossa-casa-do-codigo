package br.com.zup.cadastroveiculo

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface CarroRepository: JpaRepository<Carro, Long> {
    fun findByPlaca(placa: String): Optional<Carro>
}