package br.com.zup.cadastroveiculo

class NovoCarroResponse(
    carro: Carro
) {
    val placa = carro.placa
    val modelo = carro.modelo

    override fun toString(): String {
        return "NovoCarroResponse(placa='$placa', modelo='$modelo')"
    }
}
