package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputCarName = InputView.carName();
        String driveCount = InputView.driveCount();
        Race race = new Race(inputCarName, driveCount,new MakeRandomNumber());
        OutputView.printExecutionResult();
        race.playAndPrintEachRound();
        OutputView.printWinners(race.getWinners());
    }
}
