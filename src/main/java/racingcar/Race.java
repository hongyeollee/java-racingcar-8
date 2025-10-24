package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int driveCount;
    private final MakeNumber makeNumber;


    public Race (String rawName, int driveCount, MakeNumber makeNumber) {
        this.cars = parseNames(rawName);
        this.driveCount = driveCount;
        this.makeNumber = makeNumber;
    }

    private void playRound() {
        for (Car car : cars) car.move(makeNumber.generate());
    }

    public void playAndPrintEachRound() {
        for(int round =0; round < driveCount; round ++) {
            playRound();
            OutputView.printRound(cars);
        }
    }

    public List<String> getWinners() {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        List<String> winners = new ArrayList<>();
        for (Car car: cars) {
            if (car.getPosition() == max) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private List<Car> parseNames(String names) {
        if (names == null) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        if (names.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 없습니다.");
        }
        String [] splitNames = names.split(",");
        String [] tokens = new String[splitNames.length];

        for( int i = 0; i < splitNames.length; i++) {
            tokens[i] = splitNames[i].trim();
        }
        List<Car> list = new ArrayList<>();
        for (String token : tokens) {
            if (token.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 유효하지 않습니다.");
            }
            list.add(new Car(token));
        }
        return list;
    }

    /**
     * 테스트 전용 생성자(makeNumber 에서 랜덤숫자가 아닌 고정된숫자로 지정하여 테스트할 수 있도록 하기 위함)
     */
    public Race(List<Car> cars, MakeNumber makeNumber) {
        this.cars = cars;
        this.driveCount = 1;
        this.makeNumber = makeNumber;
    }
}
