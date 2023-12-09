package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    Car car = new Car("test");

    @DisplayName("0~3일 경우 주행거리가 늘어나지 않는 것을 확인")
    @ValueSource(strings = {"0", "1", "2", "3"})
    @ParameterizedTest
    void checkStop(int number) {
        car.checkGoOrStop(number);
        assertThat(car.getCarDistance()).isEqualTo(0);
    }

    @DisplayName("4~9일 경우 주행거리가 늘어나는 것을 확인")
    @ValueSource(strings = {"4", "5", "6", "7", "8", "9"})
    @ParameterizedTest
    void checkGo(int number) {
        car.checkGoOrStop(number);
        assertThat(car.getCarDistance()).isEqualTo(1);
    }
}