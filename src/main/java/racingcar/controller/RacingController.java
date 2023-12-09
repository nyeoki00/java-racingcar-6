package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.config.CarNameConfig;
import racingcar.domain.Car;
import racingcar.domain.CarRacing;
import racingcar.view.InputView;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RacingTimeValidator;
import racingcar.view.OutputView;

public class RacingController {


    public void run() {
        List<Car> cars = createCars(getCarNames());
        CarRacing racing = new CarRacing(cars);

        printRacingResult(getRacingTime(), racing);

        printWinner(racing);
    }

    private List<String> getCarNames() {
        CarNameValidator carNameValidator = new CarNameValidator();
        List<String> carNames = parserCarNames(InputView.requestCarNames());
        while (true) {
            try {
                carNameValidator.isValid(carNames);
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

    private void printRacingResult(int racingTime, CarRacing carRacing) {
        OutputView.printResultMessage();

        for (int i = 0; i < racingTime; i++) {
            OutputView.printRacingResult(carRacing.getRacingResult());
        }
    }

    private void printWinner(CarRacing carRacing) {
        String winners = carRacing.getWinners();
        OutputView.printWinnerMessage(winners);
    }
}
