package br.com.nats.angelo.entrypoint.dto

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Introspected
data class InstrutorRequest (
    val id: String="",
    @field:NotBlank val nome:String="",
    @field:NotBlank val cpf:String="",
    @field:NotBlank val descricao:String="",
    @field:NotNull @field:Positive val numArmas:Int=0,

    )