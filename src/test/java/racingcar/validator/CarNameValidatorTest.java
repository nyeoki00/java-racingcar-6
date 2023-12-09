package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.config.CarNameConfig;

class CarNameValidatorTest {
    CarNameValidator validator = new CarNameValidator();

    @DisplayName("각 자동차 이름이 0~5자 이내가 아닐 경우 예외 발생")
    @ValueSource(strings = {"abcdef,f,g", ",,f", ",e,"})
    @ParameterizedTest
    void checkCarNameLength(String inputCarNames) {
        checkIllegalArgumentException(inputCarNames);
    }

    @DisplayName("서로 중복되는 자동차 이름이 있을 경우 예외 발생")
    @ValueSource(strings = {"aldfe,e,w,w", "oiure,slek,lfkes,slek", "poieq,poieq,ifls"})
    @ParameterizedTest
    void checkCarNameDuplicate(String inputCarNames) {
        checkIllegalArgumentException(inputCarNames);
    }

    private void checkIllegalArgumentException(String inputCarNames) {
        List<String> carNames = Arrays.stream(inputCarNames.split(CarNameConfig.PARSER)).toList();

        assertThatThrownBy(() -> validator.validateCarName(carNames)).isInstanceOf(IllegalArgumentException.class);
    }
}