package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Race 클래스 테스트")
public class RaceTest {

    @DisplayName("race 생성자 실행하면 경주 최종 승리자를 반환")
    @Test
    void raceConstructorReturnWinners() {
        Race race = new Race("hong, soong", "2", new FixedMakeNumber(2));
        List<String> winners = race.getWinners();

        assertThat(winners).containsExactlyInAnyOrder("hong", "soong");
    }

    @DisplayName("race 생성자에 자동차 이름을 안넣음 -> IllegalArgumentException")
    @Test
    void NoCarName() {
        assertThatThrownBy(() -> new Race("  ", "1", new MakeRandomNumber()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 없습니다.");
    }

    @DisplayName("race 생성자에 잘못된 자동차이름 형식 작성 -> IllegalArgumentException")
    @Test
    void wrongFormatCarName() {
        assertThatThrownBy(() -> new Race("hong, ,soong", "1", new MakeRandomNumber()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 유효하지 않습니다.");
    }

    @DisplayName("payAndPrintEachRound 메소드로 전진 이동 후 결과 승자 반환")
    @Test
    void moveCars() {
        Car hongCar = new Car("hong");
        Car soongCar = new Car("soong");

        soongCar.move(9); // soong car position=1

        Race race = new Race(List.of(hongCar,soongCar), new FixedMakeNumber(3));
        race.playAndPrintEachRound();

        List<String> winners = race.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("soong");

    }

    @DisplayName("position 이 가장 높은 자동차(들)는(은) 자동자 경주 우승자 선정")
    @Test
    void pickWinners() {
        Car hongCar = new Car("hong");
        Car soongCar = new Car("soong");
        Car swoonCar = new Car("swoon");

        Race race = new Race(List.of(hongCar,soongCar,swoonCar), new FixedMakeNumber(1));

        hongCar.move(7); // position=1
        soongCar.move(9); // position=1
        swoonCar.move(3); // position=0

        List<String> winners = race.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("hong", "soong");
    }

    @DisplayName("시도횟수 입력시 Race 생성자에 임의의 문자입력 -> IllegalArgumentException")
    @Test
    void tryCountUseWrongString() {
        assertThatThrownBy(() -> new Race("hong, soong", "a", new MakeRandomNumber()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수에 잘못된 값을 입력하였습니다.");
    }

    @DisplayName("시도횟수 입력시 Race 생성자에 시도횟수 0 입력 -> IllegalArgumentException")
    @Test
    void tryCountUseZero() {
        assertThatThrownBy(() -> new Race("hong, soong", "0", new MakeRandomNumber()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1보다 작은수는 사용할 수 없습니다.");
    }

    @DisplayName("시도횟수 입력시 Race 생성자에 음수 입력 -> IllegalArgumentException")
    @Test
    void tryCountUseNegativeNumberString() {
        assertThatThrownBy(() -> new Race("hong, soong", "-1", new MakeRandomNumber()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1보다 작은수는 사용할 수 없습니다.");
    }
}
