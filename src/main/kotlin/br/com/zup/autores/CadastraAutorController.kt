package br.com.zup.autores

import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import jdk.incubator.http.HttpResponse
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller("/autores")
class CadastraAutorController(val autorRepository: AutorRepository) {

    @Post
    fun cadastra(@Body @Valid request : NovoAutorRequest){
        //request => dominio

        val autor = request.paraAutor()
        autorRepository.save(autor)

        println(request)
    }


}