package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingTimeValidatorTest {

    @DisplayName("숫자가 아닌 값 입력할 경우 예외 발생하는지 확인")
    @ValueSource(strings = {"가나다", "aiew", "123wdf", "igl452", "3df9r8gjs35", "", " "})
    @ParameterizedTest
    void checkNotNumber(String racingTime) {
        RacingTimeValidator RacingTimeValidator = new RacingTimeValidator();

        assertThatThrownBy(() -> RacingTimeValidator.isValid(racingTime)).isInstanceOf(IllegalArgumentException.class);
    }
}