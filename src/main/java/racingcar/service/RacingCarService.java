package racingcar.service;

import racingcar.domain.Car;
import racingcar.utils.RandomNumberGenerator;

import java.util.List;

public class RacingCarService {

    public void moveCars(List<Car> cars){
        for(Car car : cars){
            car.move(RandomNumberGenerator.createNumber());
        }
    }
}
