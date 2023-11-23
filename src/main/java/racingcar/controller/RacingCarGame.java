package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Result;
import racingcar.utils.CarsConverter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGame {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        List<String> carNames = getCarNames();
        int roundAmount = getRoundAmount();
        Cars carGroup = createCars(carNames);
        performRaces(carGroup, roundAmount);
        announceWinners(carGroup);
    }

    private List<String> getCarNames() {
        return inputView.inputNames();
    }

    private int getRoundAmount() {
        return inputView.inputRoundAmount();
    }

    private Cars createCars(final List<String> carNames) {
        List<Car> cars = CarsConverter.createCars(carNames);
        return new Cars(cars);
    }

    private void performRaces(final Cars carGroup, final int roundAmount) {
        for (int i = 0; i < roundAmount; i++) {
            Result roundResult = carGroup.moveCars();
            outputView.printRoundResult(roundResult);
        }
    }

    private void announceWinners(final Cars carGroup) {
        List<String> winners = carGroup.getWinners();
        outputView.printWinners(winners);
    }
}
