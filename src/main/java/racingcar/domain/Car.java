package racingcar.domain;

public class Car implements Comparable<Car>{

    private static final int INIT_POSITION_NUMBER = 0;
    private static final int MIN_NUMBER_FOR_MOVE = 4;
    private static final int SAME_POSITION_NUMBER = 0;
    private String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = INIT_POSITION_NUMBER;
    }

    public static Car from(String name){
        return new Car(name);
    }

    public void move(int randomNumber){
        if(randomNumber >= MIN_NUMBER_FOR_MOVE){
            position++;
        }
    }

    public boolean isSamePosition(Car car){
        int result = compareTo(car);
        if(SAME_POSITION_NUMBER == result){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }
}
