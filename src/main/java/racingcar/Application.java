package racingcar;

import racingcar.controller.RaceController;
import racingcar.domain.number.MakeRandomNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceController raceController = new RaceController(new MakeRandomNumber());
        raceController.run();
    }
}
