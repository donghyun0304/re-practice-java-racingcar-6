package racingcar.view;

import racingcar.domain.Result;
import racingcar.domain.WinningCars;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {

    private static final String MOVEDMARK = "-";

    public void printRoundResult(Result result){
        System.out.println("실행 결과");
        Map<String, Integer> roundResult = result.getResult();
        Set<Map.Entry<String, Integer>> entries = roundResult.entrySet();
        for(Map.Entry<String, Integer> entry : entries){
            System.out.println(entry.getKey() + " : " + MOVEDMARK.repeat(entry.getValue()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winnerNames){
        String joinedNames = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + joinedNames);
    }
}
