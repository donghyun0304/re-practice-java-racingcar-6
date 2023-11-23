package racingcar.validation;

import racingcar.constant.CarConstant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarValidator {

    private static final int MIN_CAR_AMOUNT = 2;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateNames(String input) {
        if (isNullOrEmptyOrWhitespace(input)
                || isSingleCar(input)
                || isOverLength(input)
                || hasDuplicateNames(input)
        ) {
            throw new IllegalArgumentException("[ERROR] 형식에 맞지 않습니다.");
        }
    }

    private static boolean isNullOrEmptyOrWhitespace(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static boolean isSingleCar(String input) {
        String[] names = input.split(CarConstant.NAME_SEPARATOR);
        return names.length < MIN_CAR_AMOUNT;
    }

    private static boolean isOverLength(String input) {
        return Arrays.stream(input.split(CarConstant.NAME_SEPARATOR))
                .anyMatch(name -> name.length() > MAX_CAR_NAME_LENGTH);
    }

    private static boolean hasDuplicateNames(String input) {
        List<String> names = Arrays.stream(input.split(CarConstant.NAME_SEPARATOR))
                .collect(Collectors.toList());
        Set<String> nonDuplicateNames = new HashSet<>(names);
        if (names.size() != nonDuplicateNames.size()) {
            return true;
        }
        return false;
    }

}
