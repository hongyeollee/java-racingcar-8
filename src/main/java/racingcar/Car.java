package racingcar;

public class Car {
    private final String name;
    private static final String REMOVE_BLANK_REGEX = "\\s+";
    private static final int MOVE_MINIMUM_NUMBER = 4;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name.trim().replaceAll(REMOVE_BLANK_REGEX, "");
    }

    private void validateName(String name) {
        if (name == null) throw new IllegalArgumentException("이름 입력이 잘못되었습니다.");
        String processName = name.trim().replaceAll(REMOVE_BLANK_REGEX, "");
        if (processName.isBlank()) throw new IllegalArgumentException("이름 입력이 비어있습니다.");
        if (processName.length() > 5) throw new IllegalArgumentException("이름은 5자 이하로 입력해주세요");
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_MINIMUM_NUMBER) {
            position += 1;
        }
    }
}
