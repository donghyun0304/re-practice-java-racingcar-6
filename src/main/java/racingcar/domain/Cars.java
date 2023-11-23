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
        Map<String, Integer> movedResult = cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
        return new Result(movedResult);
    }



    public List<String> getWinners(){
        List<Car> sortedCars = sortAscending(cars);
        Car maxiestMovedCar = sortedCars.get(cars.size() - 1);
        List<Car> winningCars = findCarsAtWinningPosition(sortedCars, maxiestMovedCar);
        return new WinningCars(winningCars).getNames();
    }

    private List<Car> sortAscending(List<Car> cars){
        return cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private List<Car> findCarsAtWinningPosition(List<Car> cars, Car maxiestMovedCar){
       return cars.stream()
                .filter(car -> maxiestMovedCar.isSamePosition(car))
                .collect(Collectors.toList());
    }


}
