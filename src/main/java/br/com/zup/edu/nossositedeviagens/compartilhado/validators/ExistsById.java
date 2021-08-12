package br.com.zup.edu.nossositedeviagens.compartilhado.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented

//Definir esse tipo de annotation como uma constraint de bean validation
@Constraint(validatedBy = {ExistsByIdValidator.class})

//Onde nossas annotations podem ser usadas.
@Target(FIELD)

//Especifica como a annotation marcada é armazenada. Escolhemos RUNTIME, para que possa ser usado pelo ambiente de tempo de execução.
@Retention(RUNTIME)

public @interface ExistsById {

    String message() default "Objeto não encontrado no banco.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}
