package task;

public enum Status {
    NEW("НОВАЯ ЗАДАЧА"),
    IN_PROGRESS("В ПРОЦЕССЕ"),
    DONE("ВЫПОЛНЕНО");

    private final String name;

    Status (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
