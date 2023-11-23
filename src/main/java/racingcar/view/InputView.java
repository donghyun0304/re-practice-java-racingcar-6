package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.CarsConverter;
import racingcar.utils.validation.CarValidator;
import racingcar.utils.validation.RoundValidator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    public List<String> inputNames(){
        return getInput(() -> {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = Console.readLine();
            CarValidator.validateNames(input);
            //밑에 검증로직 더 추가해야함
            return CarsConverter.parse(input);
        });
    }

    public int inputRoundAmount(){
        return getInput(() -> {
            System.out.println("시도할 회수는 몇회인가요?");
            String input = Console.readLine();
            RoundValidator.validateRound(input);
            return Integer.parseInt(input);
        });
    }


    private <T> T getInput(Supplier<T> inputSupplier){
        while(true){
            try{
                return inputSupplier.get();
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
