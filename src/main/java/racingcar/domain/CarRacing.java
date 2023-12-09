package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRacing {
    private static final String WINNER_DELIMITER = ", ";

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

    public String getWinners() {
        List<String> winners = new ArrayList<>();
        int maxDistance = Collections.max(racingResult.values());

        for (String key : racingResult.keySet()) {
            if (racingResult.get(key).equals(maxDistance)) {
                winners.add(key);
            }
        }

        System.out.println(winners);

        return String.join(WINNER_DELIMITER, winners);
    }
}
