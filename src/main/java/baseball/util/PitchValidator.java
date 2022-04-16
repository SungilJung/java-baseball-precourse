package baseball.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class PitchValidator implements ConstraintValidator<PitchCheck, String> {
    private static final int VALID_LENGTH = 3;
    private static final int ASCII_1 = 49;
    private static final int ASCII_9 = 57;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.isNotBlank(value) && isValidInput(value);
    }

    private boolean isValidInput(String input) {
        Map<Boolean, Set<Character>> resultMap = new HashMap<>();
        resultMap.put(true, new HashSet<>());
        resultMap.put(false, new HashSet<>());

        for (char element : input.toCharArray()) {

            Set<Character> elements = resultMap.get(isValidElement(element));
            elements.add(element);

        }

        return VALID_LENGTH == resultMap.get(true).size();
    }

    private boolean isValidElement(char element) {
        return element >= ASCII_1 && element <= ASCII_9;
    }
}
