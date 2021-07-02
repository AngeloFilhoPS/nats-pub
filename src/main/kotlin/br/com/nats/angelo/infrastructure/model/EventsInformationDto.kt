package br.com.nats.angelo.infrastructure.model

import io.micronaut.core.annotation.Introspected

@Introspected
data class EventsInformationDto(
    val events: Events,
    val instrutorEvent: InstrutorEvent
)