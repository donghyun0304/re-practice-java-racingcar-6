package racingcar.utils;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsConverter {

    private static final String SPLIT = ",";

    public static List<String> parse(String names) {
        String trimmedNames = names.trim();
        return Arrays.stream(trimmedNames.split(SPLIT))
                .collect(Collectors.toList());
    }

    public static List<Car> createCars(List<String> names){
        return names.stream()
                .map(name -> Car.from(name))
                .collect(Collectors.toList());
    }
}
