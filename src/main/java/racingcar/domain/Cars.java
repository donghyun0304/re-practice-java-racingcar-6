package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Result moveCars(){
        for(Car car : cars){
            car.move(RandomNumberGenerator.createNumber());
        }
        return new Result(getMovedResult());
    }

    private Map<String, Integer> getMovedResult() {
        Map<String, Integer> movedResult = cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition, (oldValue, newValue) -> oldValue
                        ,LinkedHashMap::new));
        return movedResult;
    }


    public List<String> getWinners(){
        List<Car> sortedCars = sortAscending(cars);
        Car maxiestMovedCar = sortedCars.get(cars.size() - 1);
        List<Car> winningCars = findCarsAtWinningPosition(sortedCars, maxiestMovedCar);
        return new WinningCars(winningCars).getNames();
    }

    private List<Car> sortAscending(final List<Car> cars){
        return cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private List<Car> findCarsAtWinningPosition(final List<Car> cars, final Car maxiestMovedCar){
       return cars.stream()
                .filter(car -> maxiestMovedCar.isSamePosition(car))
                .collect(Collectors.toList());
    }


}
