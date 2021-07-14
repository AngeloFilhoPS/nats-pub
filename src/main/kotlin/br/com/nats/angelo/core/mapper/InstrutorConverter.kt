package br.com.nats.angelo.core.mapper

import br.com.nats.angelo.core.model.Instrutor
import br.com.nats.angelo.entrypoint.dto.InstrutorRequest
import br.com.nats.angelo.infrastructure.model.InstrutorEvent

class InstrutorConverter {


    companion object{
        fun instrutorRequestToInstrutorEvent(instrutorRequest: InstrutorRequest)=
            InstrutorEvent(instrutorRequest.id,instrutorRequest.nome,instrutorRequest.cpf,instrutorRequest.descricao,instrutorRequest.numArmas)

        fun instrutorToInstrutorRequest(instrutor: Instrutor)=
            InstrutorRequest(instrutor.id,instrutor.nome,instrutor.cpf,instrutor.descricao,instrutor.numArmas)

        fun instutorRequestToInstrutor(instrutorRequest: InstrutorRequest)=
            Instrutor(instrutorRequest.id,instrutorRequest.nome,instrutorRequest.cpf,instrutorRequest.descricao,instrutorRequest.numArmas)

        fun instrutorEventToInstrutor(id: InstrutorRequest)=
            Instrutor(id=id.toString(),"","","",0)

        fun instrutorToInstrutorEvent(instrutor: Instrutor)=
            InstrutorEvent(instrutor.id,instrutor.nome,instrutor.cpf,instrutor.descricao,instrutor.numArmas)
    }


}