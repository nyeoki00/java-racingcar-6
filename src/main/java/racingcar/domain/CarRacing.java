package racingcar.domain;

import java.util.HashMap;
import java.util.List;

public class CarRacing {
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

    /*public void checkWinner() {
        List<String> carsName = new ArrayList<>();
        List<Integer> carsDistance = new ArrayList<>();

        for (Car car : cars) {
            carsName.add(car.getCarName());
            carsDistance.add(car.getCarDistance());
        }

        int maxDistance = Collections.max(carsDistance);
        String winner = "최종우승자 : ";

        winner += carsName.get(carsDistance.indexOf(maxDistance));

        System.out.println(winner);
    }*/

    public HashMap<String, Integer> getRacingResult() {
        for (Car car : cars) {
            car.goRacing();
            racingResult.put(car.getCarName(), car.getCarDistance());
        }

        System.out.println(racingResult);

        return racingResult;
    }
}
