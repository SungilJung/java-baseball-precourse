package baseball.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class PitchValidator implements ConstraintValidator<PitchCheck, String> {
    private static final int VALID_LENGTH = 3;
    private static final int ASCII_1 = 49;
    private static final int ASCII_9 = 57;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.isNotBlank(value) && VALID_LENGTH == value.length() && VALID_LENGTH == (int) value.chars()
                .filter(data -> data >= ASCII_1 && data <= ASCII_9).distinct().count();
    }
}
