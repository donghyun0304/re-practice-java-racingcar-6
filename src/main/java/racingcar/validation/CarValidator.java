package racingcar.validation;

import racingcar.constant.CarConstant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarValidator {

    private static final int MIN_CAR_AMOUNT = 2;

    public static void validateNames(final String input) {
        if (isNullOrEmptyOrWhitespace(input)
                || isSingleCar(input)
                || isOverLength(input)
                || hasDuplicateNames(input)
        ) {
            throw new IllegalArgumentException("[ERROR] 형식에 맞지 않습니다.");
        }
    }

    private static boolean isNullOrEmptyOrWhitespace(final String input) {
        return input == null || input.trim().isEmpty();
    }

    private static boolean isSingleCar(final String input) {
        String[] names = input.split(CarConstant.NAME_SEPARATOR);
        return names.length < MIN_CAR_AMOUNT;
    }

    private static boolean isOverLength(final String input) {
        return Arrays.stream(input.split(CarConstant.NAME_SEPARATOR))
                .anyMatch(name -> name.length() > CarConstant.MAX_CAR_NAME_LENGTH);
    }

    private static boolean hasDuplicateNames(final String input) {
        List<String> names = Arrays.stream(input.split(CarConstant.NAME_SEPARATOR))
                .collect(Collectors.toList());
        Set<String> nonDuplicateNames = new HashSet<>(names);
        if (names.size() != nonDuplicateNames.size()) {
            return true;
        }
        return false;
    }

}
