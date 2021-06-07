package br.com.zup.carros

import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import javax.inject.Singleton
import javax.validation.Constraint
import kotlin.annotation.AnnotationTarget.*

@Target(FIELD, CONSTRUCTOR)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [Placa.PlacaValidador::class])
annotation class Placa(val message: String = "Placa Inválida") {

    @Singleton
    class PlacaValidador : ConstraintValidator<Placa, String> {

        override fun isValid(
            value: String?,
            annotationMetadata: AnnotationValue<Placa>,
            context: ConstraintValidatorContext
        ): Boolean {

            if (value == null) {
                return true
            }

            return value.matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}".toRegex())
        }

    }
}
