package task;

import java.util.Objects;

public class Task {
    protected String name;
    protected String description;
    private static int nextID = 1;
    protected int id;
    protected Status status;

    public Task(String name, String description) {
        this.status = Status.NEW;
        this.id = nextID++;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (this.getClass() != obj.getClass())) return false;
        Task otherTask = (Task) obj;
        return Objects.equals(this.name, otherTask.name) && Objects.equals(this.description, otherTask.description) &&
                Objects.equals(this.status, otherTask.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, status);
    }
}
