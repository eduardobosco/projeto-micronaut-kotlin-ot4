package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("https://viacep.com.br/ws/25713030/json/")
interface EnderecoClient {

    @Get("{cep}")
    //@Consumes(MediaType.APPLICATION_XML) - Para serializar JSON em XML
    fun consulta(cep:String) : HttpResponse<EnderecoResponse>
}