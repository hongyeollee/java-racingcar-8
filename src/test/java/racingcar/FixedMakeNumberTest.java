package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("FixedMakeNumber 클래스 테스트")
public class FixedMakeNumberTest {

    @DisplayName("지정숫자 반환(테스트코드용)")
    @Test
    void returnFixedNumber() {
        assertThat(new FixedMakeNumber(6).generate()).isEqualTo(6);
    }
}
