package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_RACING_TIME = "시도할 회수는 몇회인가요?";

    public static String requestCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
        return Console.readLine();
    }

    public static String requestRacingTime() {
        System.out.println(REQUEST_RACING_TIME);
        return Console.readLine();
    }
}
