package br.com.nats.angelo.infrastructure.service

import br.com.nats.angelo.core.port.NatsServicePort
import br.com.nats.angelo.infrastructure.client.InstrutorClient
import br.com.nats.angelo.infrastructure.model.Events
import br.com.nats.angelo.infrastructure.model.EventsInformationDto
import br.com.nats.angelo.infrastructure.model.InstrutorEvent
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class NatsService(private val client:InstrutorClient): NatsServicePort {

    private val LOGGER = LoggerFactory.getLogger(this::class.java)

    override fun sendCreateNats(instrutorEvent: InstrutorEvent):EventsInformationDto {
        val eventsInfo = EventsInformationDto(Events.SAVE_INSTRUTOR,instrutorEvent)
        client.sendInstrutor(eventsInfo)
        LOGGER.info("CREATE message sent successfully")
        return eventsInfo
    }

    override fun sendDeleteNats(instrutorEvent: InstrutorEvent) {
        client.sendInstrutor((EventsInformationDto(Events.DELETE_INSTRUTOR,instrutorEvent)))
        LOGGER.info("DELETE message set successfully")
    }

    override fun sendUpdateNats(instrutorEvent: InstrutorEvent) {
        client.sendInstrutor((EventsInformationDto(Events.UPDATE_INSTRUTOR,instrutorEvent)))
        LOGGER.info("UPDATE message sent successfully")
    }
}