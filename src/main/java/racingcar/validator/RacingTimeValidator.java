package racingcar.validator;

import java.util.regex.Pattern;

public class RacingTimeValidator {
    public static final int MIN_RACING_TIME = 1;

    private final Pattern NUMBER = Pattern.compile("^[\\d]*$");

    public void isValid(String racingTime) {
        isNumber(racingTime);
    }

    private void isNumber(String racingTime) {
        boolean isInvalidNumber = !NUMBER.matcher(racingTime).matches() || racingTime.isEmpty();

        if (isInvalidNumber) {
            throw new IllegalArgumentException();
        }
    }
}
