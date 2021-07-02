package br.com.nats.angelo.core.port

import br.com.nats.angelo.core.model.Instrutor
import javax.inject.Singleton

@Singleton
interface InstrutorServicePort {
    fun sendCreateMessage(instrutor: Instrutor)
    fun sendDeleteMessage(instrutor: Instrutor)
    fun sendUpdateMessage(instrutor: Instrutor)
}