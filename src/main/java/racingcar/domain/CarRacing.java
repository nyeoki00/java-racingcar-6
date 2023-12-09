package racingcar.domain;

import java.util.List;

public class CarRacing {
    private static final String DISTANCE_SYMBOL = "-";

    private final List<Car> cars;

    public CarRacing(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void repeatRacing(int racingTime) {
        for (int i = 0; i < racingTime; i++) {
            getRacingResult();
        }
    }

    private void getRacingResult() {
        for (Car car : cars) {
            car.goRacing();
            System.out.println(car.getCarName() + ": " + DISTANCE_SYMBOL.repeat(car.getCarDistance()));
        }
        System.out.println();
    }
}
