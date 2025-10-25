package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.number.MakeNumber;
import racingcar.domain.number.MakeRandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final MakeNumber makeNumber;

    public RaceController(MakeNumber makeNumber) {
        this.makeNumber = makeNumber;
    }

    public void run() {
        String names = InputView.carName();
        String driveCount = InputView.driveCount();

        Race race = new Race(names, driveCount,this.makeNumber);

        OutputView.printExecutionResult();
        race.playAndPrintEachRound();
        OutputView.printWinners(race.getWinners());
    }
}
