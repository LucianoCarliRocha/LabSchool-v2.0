package techdevinhouse.labschool.ValidadorDeEnun;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValorEnumValidador.class)


public @interface ValorEnum {

    Class<? extends Enum <?>> enumClass();
    String message () default "Deve ser preenchido corretamente, com os valores de enun{enumClass}";
    Class <?>[] groups() default {};
    Class<? extends Payload> [] payload () default {};
}
