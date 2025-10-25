package racingcar.domain.number;

import camp.nextstep.edu.missionutils.Randoms;

public class MakeRandomNumber implements MakeNumber {
    private static final int MIN = 0;
    private static final int MAX = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN,MAX);
    }
}
