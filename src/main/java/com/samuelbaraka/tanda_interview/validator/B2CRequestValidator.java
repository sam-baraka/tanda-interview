package com.samuelbaraka.tanda_interview.validator;

import com.samuelbaraka.tanda_interview.model.B2CRequest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class B2CRequestValidator {

    private javax.validation.Validator validator;

    public B2CRequestValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public Set<ConstraintViolation<B2CRequest>> validate(B2CRequest request) {
        return validator.validate(request);
    }
}
