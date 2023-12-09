package racingcar.validator;

import static racingcar.config.ErrorMessage.INVALID_RACING_TIME;

import java.util.regex.Pattern;

public class RacingTimeValidator {
    public static final int MIN_RACING_TIME = 1;
    public static final int MAX_RACING_TIME = 100_000;

    private final Pattern NUMBER = Pattern.compile("^[\\d]*$");

    public void isValid(String racingTime) {
        try {
            isNumber(racingTime);
            checkRange(Integer.parseInt(racingTime));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_RACING_TIME.getMessage());
        }
    }

    private void isNumber(String racingTime) {
        boolean isInvalidNumber = !NUMBER.matcher(racingTime).matches() || racingTime.isEmpty();

        if (isInvalidNumber) {
            throw new IllegalArgumentException(INVALID_RACING_TIME.getMessage());
        }
    }

    private void checkRange(int racingTime) {
        if (racingTime < MIN_RACING_TIME || racingTime > MAX_RACING_TIME) {
            throw new IllegalArgumentException(INVALID_RACING_TIME.getMessage());
        }
    }
}
