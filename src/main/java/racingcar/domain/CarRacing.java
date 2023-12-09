package racingcar.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CarRacing {
    private static final String WINNER_DELIMITER = ",";

    private final List<Car> cars;
    private final HashMap<String, Integer> racingResult = new HashMap<>();

    public CarRacing(List<Car> cars) {
        this.cars = cars;

        for (Car car : cars) {
            racingResult.put(car.getCarName(), car.getCarDistance());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public HashMap<String, Integer> getRacingResult() {
        for (Car car : cars) {
            car.goRacing();
            racingResult.put(car.getCarName(), car.getCarDistance());
        }

        System.out.println(racingResult);

        return racingResult;
    }

    public String checkWinner() {
        List<String> carsName = racingResult.keySet().stream().toList();
        List<Integer> carsDistance = racingResult.values().stream().toList();

        System.out.println(carsName);
        System.out.println(carsDistance);

        int maxDistance = Collections.max(carsDistance);
        int indexOfMaxDistance = carsDistance.indexOf(maxDistance);
        String winners = carsName.get(indexOfMaxDistance);

        System.out.println(winners);

        return winners;
    }
}
