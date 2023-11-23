package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;


    public static int createNumber(){
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        validateNumberRange(randomNumber);
        return randomNumber;
    }

    private static void validateNumberRange(final int randomNumber){
        if(!(randomNumber >= MIN_NUMBER && randomNumber <= MAX_NUMBER)){
            throw new IllegalArgumentException("[ERROR] 0~9 사이의 숫자가 아닙니다.");
        }
    }


}
