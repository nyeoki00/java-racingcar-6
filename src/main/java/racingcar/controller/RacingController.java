package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.config.CarNameConfig;
import racingcar.domain.Car;
import racingcar.io.InputView;
import racingcar.validator.CarNameValidator;

public class RacingController {


    public void run() {
        createCars(getCarNames());
        getRacingTime();
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

    private void createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        //확인용
        for (Car car : cars) {
            System.out.println(car.getCarName() + ": " + car.getCarDistance());
        }
    }

    private void getRacingTime() {
        InputView.requestRacingTime();
    }
}
