package racingcar.utils;

import racingcar.constant.CarConstant;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsConverter {


    public static List<String> parse(final String names) {
        String trimmedNames = names.trim();
        return Arrays.stream(trimmedNames.split(CarConstant.NAME_SEPARATOR))
                .collect(Collectors.toList());
    }

    public static List<Car> createCars(final List<String> names){
        return names.stream()
                .map(name -> Car.from(name))
                .collect(Collectors.toList());
    }
}
