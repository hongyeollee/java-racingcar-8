package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car 클래스 테스트")
public class CarTest {

    @DisplayName("자동차 생성자로 자동차 이름생성시 검증 및 공백처리된 자동차 이름 반환")
    @Test
    void 검증된_자동차_이름_생성과_이름출력() {
        Car car = new Car(" h on g ");
        assertThat(car.getName()).isEqualTo("hong");
    }

    @DisplayName("자동차이름 입력 null -> IllegalArgumentException")
    @Test
    void 자동차_이름에_null() {
        assertThatThrownBy(() -> new Car(null)).isInstanceOf(IllegalArgumentException.class).hasMessage("이름 입력이 잘못되었습니다.");
    }

    @DisplayName("자동차 이름 빈값 -> IllegalArgumentException")
    @Test
    void 자동차_이름에_빈값() {
        assertThatThrownBy(() -> new Car(" ")).isInstanceOf(IllegalArgumentException.class).hasMessage("이름 입력이 비어있습니다.");
    }

    @DisplayName("자동차 이름 다섯글자 초과(한글) → IllegalArgumentException")
    @Test
    void 자동차_이름_다섯글자_초과_한글() {
        assertThatThrownBy(() -> new Car("내차는여섯글자")).isInstanceOf(IllegalArgumentException.class).hasMessage("이름은 5자 이하로 입력해주세요");
    }

    @DisplayName("자동차 이름 다섯글자 초과(영어) → IllegalArgumentException")
    @Test
    void 자동차_이름_다섯글자_초과_영어() {
        assertThatThrownBy(() -> new Car("abcdef")).isInstanceOf(IllegalArgumentException.class).hasMessage("이름은 5자 이하로 입력해주세요");
    }

    @DisplayName("자동차의 position의 기본값이 0으로 되어있는지 확인")
    @Test
    void 자동차_포지션_확인() {
        Car car = new Car(" h on g ");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("무작위 숫자 4미만 부여 -> position 유지")
    @Test
    void 무작위_숫자_4미만_부여시_포지션_유지() {
        Car car = new Car("hong");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("무작위 숫자 4이상 부여 -> position + 1")
    @Test
    void 무작위_숫자_4이상_부여시_포지션_1_추가() {
        Car car = new Car("hong");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
