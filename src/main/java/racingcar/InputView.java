package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String carName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static int driveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String readLine = Console.readLine();
        return parseIntNumString(readLine);
    }

    private static int parseIntNumString(String numString) {
        try {
            int number = Integer.parseInt(numString.trim());
            if (number <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1보다 작은수는 사용할 수 없습니다.");
            }

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수에 잘못된 값을 입력하였습니다.");
        }
    }
}
