package baseball.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RestartValidator implements ConstraintValidator<RestartCheck, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length() == 1 && (value.charAt(0) == '1' || value.charAt(0) == '2');
    }
}
