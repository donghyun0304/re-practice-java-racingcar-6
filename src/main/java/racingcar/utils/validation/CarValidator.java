package racingcar.utils.validation;

import java.util.Arrays;
import java.util.List;

public class CarValidator {

    private static final int MIN_CAR_AMOUNT = 2;

    public static final void validatorCarAmount(String input){
        List<String> names = Arrays.asList(input.split(","));
        if(names.size() >= MIN_CAR_AMOUNT){
            throw new IllegalArgumentException("[ERROR] 최소 2대의 차량이 존재해야 합니다.");
        }
    }
    


}
