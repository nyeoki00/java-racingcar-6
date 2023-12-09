package racingcar.domain;

public class Car {
    private final String carName;
    private final int carDistance;

    public Car(String carName) {
        this.carName = carName;
        this.carDistance = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarDistance() {
        return carDistance;
    }
}
