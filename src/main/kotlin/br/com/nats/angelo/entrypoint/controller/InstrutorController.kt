package br.com.nats.angelo.entrypoint.controller

import br.com.nats.angelo.core.mapper.InstrutorConverter
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
    fun DeletaInstrutorParaNats(@PathVariable id: UUID):HttpResponse<Any>{
        val instrutoDTO = InstrutorRequest(id.toString(),"","","",0)
        instrutorServicePort.sendDeleteMessage(InstrutorConverter.instrutorEventToInstrutor(instrutoDTO))
        return HttpResponse.accepted()
    }

    @Put
    fun UpdateInstrutorParaNats(@PathVariable id: UUID,@Body @Valid instrutorRequest: InstrutorRequest):HttpResponse<Any>{

        val instrutorDTO = InstrutorRequest(id.toString(),instrutorRequest.nome,instrutorRequest.cpf,instrutorRequest.descricao,instrutorRequest.numArmas)
        instrutorServicePort.sendUpdateMessage(InstrutorConverter.instutorRequestToInstrutor(instrutorDTO))

        return HttpResponse.accepted()
    }

}