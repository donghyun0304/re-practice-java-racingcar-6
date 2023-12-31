package racingcar.validation;

public class RoundValidator {

    public static void validateRound(final String input){
        if(!isNumeric(input) || !isNaturalNumber(input)){
            throw new IllegalArgumentException("[ERROR] 0이상의 자연수를 입력 해 주세요.");
        }
    }

    private static boolean isNumeric(final String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isNaturalNumber(final String input){
        if(Integer.parseInt(input) > 0){
            return true;
        }
        return false;
    }
}
