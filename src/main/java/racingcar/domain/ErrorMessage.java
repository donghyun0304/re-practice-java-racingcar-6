package racingcar.domain;

import racingcar.constant.CarConstant;

public class ErrorMessage {

    public static final String CAR_NAME_LENGTH_IS_INVALID = "[ERROR] 이름은 " + CarConstant.MAX_CAR_NAME_LENGTH
            + "자 이하로 입력해야 합니다.";
}
