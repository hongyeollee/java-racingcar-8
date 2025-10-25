package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.domain.Car;

public class OutputView {

    public static void printExecutionResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        StringJoiner joiner = new StringJoiner(", ");
        for (String winner : winners) {
            joiner.add(winner);
        }
        System.out.println("최종 우승자 : " + joiner);
    }
}