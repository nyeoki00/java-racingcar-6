package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.io.InputView;

public class RacingController {
    public void run() {
        validateCarNames();
    }

    private void validateCarNames() {
        System.out.println(parserCarNames(InputView.requestCarNames()));
    }

    private List<String> parserCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }
}
