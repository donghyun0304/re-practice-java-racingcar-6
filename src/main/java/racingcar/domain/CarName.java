package racingcar.domain;

import racingcar.constant.CarConstant;

public class CarName {

    private String name;

    public CarName(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name){
        if(name.length() > CarConstant.MAX_CAR_NAME_LENGTH){
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_IS_INVALID);
        }
    }

    public String getName() {
        return name;
    }
}
