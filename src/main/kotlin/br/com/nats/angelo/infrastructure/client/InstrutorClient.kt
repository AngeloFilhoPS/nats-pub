package br.com.nats.angelo.infrastructure.client

import br.com.nats.angelo.infrastructure.model.EventsInformationDto
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface InstrutorClient {

    @Subject("plataform.instrutor.cadastro")
    fun sendInstrutor(eventsInformationDto: EventsInformationDto)


}