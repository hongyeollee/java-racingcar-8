package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("InputViewTest 클래스 테스트")
public class InputViewTest extends NsTest {

    @DisplayName("driveCount()에서 시도횟수 입력시 parseIntNumString(String numString)로 문자로 입력한 숫자 값을 int타입으로 반환한다.")
    @Test
    void String타입의_숫자_int타입으로_반환() {
        run("3");
        assertThat(InputView.driveCount()).isEqualTo(3);
    }

    @DisplayName("driveCount()에서 시도횟수 입력시 parseIntNumString(String numString)로 임의의 문자를 넣으면 IllegalArgumentException을 던진다")
    @Test
    void 시도횟수가_임의의_문자면_예외규칙_발생() {
        run("abc");
        assertThatThrownBy(InputView::driveCount).isInstanceOf(IllegalArgumentException.class).hasMessage("시도 횟수에 잘못된 값을 입력하였습니다.");
    }

    @DisplayName("driveCount()에서 시도횟수 입력시 parseIntNumString(String numString)로 시도횟수가 0이면 IllegalArgumentException을 던진다")
    @Test
    void 시도횟수가_0이면_예외규칙_발생() {
        run("0");
        assertThatThrownBy(InputView::driveCount).isInstanceOf(IllegalArgumentException.class).hasMessage("시도 횟수는 1보다 작은수는 사용할 수 없습니다.");
    }

    @DisplayName("driveCount()에서 시도횟수 입력시 parseIntNumString(String numString)로 시도횟수가 음수면 IllegalArgumentException을 던진다")
    @Test
    void 시도횟수가_음수면_예외규칙_발생() {
        run("-4");
        assertThatThrownBy(InputView::driveCount).isInstanceOf(IllegalArgumentException.class).hasMessage("시도 횟수는 1보다 작은수는 사용할 수 없습니다.");
    }

    @Override
    protected void runMain() {
    }
}
