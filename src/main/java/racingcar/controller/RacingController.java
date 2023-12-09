package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.config.CarNameConfig;
import racingcar.io.InputView;
import racingcar.validator.CarNameValidator;

public class RacingController {


    public void run() {
        System.out.println(getCarNames());
    }

    private List<String> getCarNames() {
        CarNameValidator carNameValidator = new CarNameValidator();
        while (true) {
            try {
                List<String> carNames = parserCarNames(InputView.requestCarNames());
                carNameValidator.validateCarName(carNames);
                return carNames;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> parserCarNames(String carNames) {
        return Arrays.stream(carNames.split(CarNameConfig.PARSER)).map(String::trim).toList();
    }
}
