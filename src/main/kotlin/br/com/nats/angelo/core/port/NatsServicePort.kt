package br.com.nats.angelo.core.port

import br.com.nats.angelo.infrastructure.model.EventsInformationDto
import br.com.nats.angelo.infrastructure.model.InstrutorEvent
import javax.inject.Singleton


@Singleton
interface NatsServicePort {
    fun sendCreateNats(instrutorEvent: InstrutorEvent):EventsInformationDto
    fun sendDeleteNats(instrutorEvent: InstrutorEvent)
    fun sendUpdateNats(instrutorEvent: InstrutorEvent)
}