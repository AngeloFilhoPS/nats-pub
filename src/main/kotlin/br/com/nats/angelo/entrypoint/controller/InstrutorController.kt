package br.com.nats.angelo.entrypoint.controller

import br.com.nats.angelo.core.mapper.InstrutorConverter
import br.com.nats.angelo.core.model.Instrutor
import br.com.nats.angelo.core.port.InstrutorServicePort
import br.com.nats.angelo.entrypoint.dto.InstrutorRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import java.util.*
import javax.validation.Valid

@Validated
@Controller("/instrutores")
class InstrutorController(private val instrutorServicePort: InstrutorServicePort) {


    @Post
    fun InstrutorParaNats(@Body @Valid instrutorRequest: InstrutorRequest ):HttpResponse<Any>{
        instrutorServicePort.sendCreateMessage(InstrutorConverter.instutorRequestToInstrutor(instrutorRequest))
     return HttpResponse.accepted()
    }

    @Delete("/{id}")
    fun DeletaInstrutorParaNats(@QueryValue id: UUID):HttpResponse<Any>{

        instrutorServicePort.sendDeleteMessage(InstrutorConverter.instrutorEventToInstrutor(id=id.toString()))
        return HttpResponse.accepted()
    }

    @Put
    fun UpdateInstrutorParaNats(@Body @Valid instrutorRequest: InstrutorRequest):HttpResponse<Any>{

        instrutorServicePort.sendUpdateMessage(InstrutorConverter.instutorRequestToInstrutor(instrutorRequest))

        return HttpResponse.accepted()
    }

}