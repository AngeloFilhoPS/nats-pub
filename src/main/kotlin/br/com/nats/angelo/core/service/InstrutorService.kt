package br.com.nats.angelo.core.service

import br.com.nats.angelo.core.mapper.InstrutorConverter
import br.com.nats.angelo.core.model.Instrutor
import br.com.nats.angelo.core.port.InstrutorServicePort
import br.com.nats.angelo.core.port.NatsServicePort
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class InstrutorService(private val service: NatsServicePort):InstrutorServicePort {

    private  val LOGGER = LoggerFactory.getLogger(this::class.java)

    override fun sendCreateMessage(instrutor: Instrutor) {
        service.sendCreateNats(
            InstrutorConverter.instrutorRequestToInstrutorEvent(
                InstrutorConverter.instrutorToInstrutorRequest(instrutor)
            )
        )
    }

    override fun sendDeleteMessage(instrutor: Instrutor) {

        service.sendDeleteNats(
            InstrutorConverter.instrutorRequestToInstrutorEvent(
                InstrutorConverter.instrutorToInstrutorRequest(instrutor)
            )
        )

    }

    override fun sendUpdateMessage(instrutor: Instrutor) {

        service.sendUpdateNats(
            InstrutorConverter.instrutorRequestToInstrutorEvent(
                InstrutorConverter.instrutorToInstrutorRequest(instrutor)
            )
        )

    }
}