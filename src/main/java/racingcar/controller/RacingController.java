package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.config.CarNameConfig;
import racingcar.domain.Car;
import racingcar.domain.CarRacing;
import racingcar.io.InputView;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RacingTimeValidator;

public class RacingController {


    public void run() {
        List<Car> cars = createCars(getCarNames());
        CarRacing racing = new CarRacing(cars);

        racing.repeatRacing(getRacingTime());
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

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        //확인용
        for (Car car : cars) {
            System.out.println(car.getCarName() + ": " + car.getCarDistance());
        }

        return cars;
    }

    private int getRacingTime() {
        RacingTimeValidator racingTimeValidator = new RacingTimeValidator();

        while (true) {
            try {
                String racingTime = InputView.requestRacingTime();
                racingTimeValidator.isValid(racingTime);
                return Integer.parseInt(racingTime);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
