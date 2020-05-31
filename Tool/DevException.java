package Tool;

public class DevException extends Exception {
    String description;

    public DevException() {
        super();
        description = "[DevException] deving....";
    }
}
