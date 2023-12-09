package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.config.CarNameConfig;
import racingcar.io.InputView;
import racingcar.validator.CarNameValidator;

public class RacingController {


    public void run() {
        getCarNames();
    }

    private void getCarNames() {
        CarNameValidator carNameValidator = new CarNameValidator();
        List<String> carNames = parserCarNames(InputView.requestCarNames());

        try {
            carNameValidator.validateCarName(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        for(String carName : carNames) {
            System.out.println(carName);
            System.out.println(carName.length());
        }
    }

    private List<String> parserCarNames(String carNames) {
        return Arrays.stream(carNames.split(CarNameConfig.PARSER)).map(String::trim).toList();
    }
}
