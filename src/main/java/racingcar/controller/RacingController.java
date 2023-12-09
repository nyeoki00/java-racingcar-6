package racingcar.controller;

import racingcar.io.InputView;

public class RacingController {
    public void run() {
        validateCarNames();
    }

    public void validateCarNames() {
        System.out.println(InputView.requestCarNames());
    }
}
