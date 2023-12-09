package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String carName;
    private int carDistance;

    public Car(String carName) {
        this.carName = carName;
        carDistance = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarDistance() {
        return carDistance;
    }

    public void goRacing() {
        int number = Randoms.pickNumberInRange(0, 9);

        checkGoOrStop(number);
    }

    public void checkGoOrStop(int number) {
        if (number >= 4) {
            carDistance++;
        }
    }
}
