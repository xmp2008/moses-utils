package cn.xmp.moses.validator.annotations;

import cn.xmp.moses.validator.AbstractValidator;
import cn.xmp.moses.validator.validators.NotEmptyValidator;
import org.hibernate.validator.constraints.Range;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {}
)
public @interface NotEmpty {
    String message() default "message.validator.NotEmpty";

    String[] when() default {};

    Class<? extends AbstractValidator> validator() default NotEmptyValidator.class;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        Range[] value();
    }
}
