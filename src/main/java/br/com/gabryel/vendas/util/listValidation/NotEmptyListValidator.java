package br.com.gabryel.vendas.util.listValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List<?>> {

    @Override
    public boolean isValid(List<?> list, ConstraintValidatorContext constraintValidatorContext) {
        return !CollectionUtils.isEmpty(list);
    }

    @Override
    public void initialize(NotEmptyList constraintAnnotation) {
    }

}
