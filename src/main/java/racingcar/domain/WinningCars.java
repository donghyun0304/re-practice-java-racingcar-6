package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningCars {

    private final List<Car> cars;

    public WinningCars(List<Car> cars){
        this.cars = new ArrayList<>(cars);
    }

    public List<String> getNames(){
        return cars.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
