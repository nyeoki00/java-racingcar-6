package racingcar.validator;

import static racingcar.config.CarNameConfig.MAX_CAR_NAME_LENGTH;

import java.util.List;
import racingcar.config.ErrorMessage;

public class CarNameValidator {
    public void validateCarName(List<String> carNames) {
        checkLengthByCarName(carNames);
    }

    private void checkLengthByCarName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH || carName.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
            }
        }
    }
}
