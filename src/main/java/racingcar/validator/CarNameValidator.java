package racingcar.validator;

import static racingcar.config.CarNameConfig.MAX_CAR_NAME_LENGTH;
import static racingcar.config.ErrorMessage.INVALID_CAR_NAME_DUPLICATE;
import static racingcar.config.ErrorMessage.INVALID_CAR_NAME_LENGTH;

import java.util.List;
import java.util.Set;

public class CarNameValidator {
    public void validateCarName(List<String> carNames) {
        System.out.println(carNames.size());
        for (String carName : carNames) {
            System.out.println(carName);
            System.out.println(carName.length());
        }
        checkLengthByCarName(carNames);
        checkDuplicateCarName(carNames);
        checkEmpty(carNames);
    }

    private void checkLengthByCarName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH || carName.isEmpty()) {
                throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
            }
        }
    }

    private void checkDuplicateCarName(List<String> carNames) {
        Set<String> carNamesExceptDuplicate = Set.copyOf(carNames);
        if (carNamesExceptDuplicate.size() != carNames.size()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_DUPLICATE.getMessage());
        }
    }

    private void checkEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }
}
