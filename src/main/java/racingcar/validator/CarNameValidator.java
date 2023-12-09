package racingcar.validator;

import static racingcar.config.CarNameConfig.MAX_CAR_NAME_LENGTH;

import java.util.List;
import java.util.Set;
import racingcar.config.ErrorMessage;

public class CarNameValidator {
    public void validateCarName(List<String> carNames) {
        checkLengthByCarName(carNames);
        checkDuplicateCarName(carNames);
    }

    private void checkLengthByCarName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH || carName.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
            }
        }
    }

    private void checkDuplicateCarName(List<String> carNames) {
        Set<String> carNamesExceptDuplicate = Set.copyOf(carNames);
        if (carNamesExceptDuplicate.size() != carNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_DUPLICATE.getMessage());
        }
    }
}
