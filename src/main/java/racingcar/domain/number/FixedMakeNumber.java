package racingcar.domain.number;

public class FixedMakeNumber implements MakeNumber {
    private final int number;

    public FixedMakeNumber(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return this.number;
    }
}