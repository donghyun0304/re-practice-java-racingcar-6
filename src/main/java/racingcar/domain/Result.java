package racingcar.domain;

import java.util.Collections;
import java.util.Map;

public class Result {

    private final Map<String, Integer> result;

    public Result(Map<String, Integer> result) {
        this.result = result;
    }

    public Map<String, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
