package racingcar.config;

public enum ErrorMessage {
    INVALID_CAR_NAME_LENGTH("[ERROR] 각 자동차 이름은 " + CarNameConfig.MIN_CAR_NAME_LENGTH + "~"
            + CarNameConfig.MAX_CAR_NAME_LENGTH + "자 이내로 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
