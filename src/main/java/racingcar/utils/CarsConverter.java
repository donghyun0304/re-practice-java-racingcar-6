package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsConverter {

    private static final String SPLIT = ",";

    public static List<String> parse(String names){
        return Arrays.stream(names.split(SPLIT))
                .collect(Collectors.toList());
    }
}
