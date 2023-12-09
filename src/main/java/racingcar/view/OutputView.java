package racingcar.view;

import java.util.HashMap;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String CAR_RESULT_DIVIDER = ":";
    private static final String DISTANCE_SYMBOL = "-";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
        System.out.println();
    }

    public static void printRacingResult(HashMap<String, Integer> racingResult) {
        for (String carName : racingResult.keySet()) {
            System.out.println(carName + " " + CAR_RESULT_DIVIDER + " "
                    + DISTANCE_SYMBOL.repeat(racingResult.get(carName)));
        }

        System.out.println();
    }
}
