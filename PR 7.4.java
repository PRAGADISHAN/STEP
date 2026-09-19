class Locker {
    private String code;
    private final int lockerNumber;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String oldCode, String newCode) {
        if (code.equals(oldCode)) {
            code = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
    // No getCode() - write only
}

public class Main {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println(l.changeCode("1234", "5678")); // true
        System.out.println(l.changeCode("0000", "9999")); // false
    }
}