package task;

import java.util.ArrayList;
import java.util.Objects;

public class Epic extends Task {
    protected ArrayList <Subtask> subtasks;

    public Epic(String name, String description) {
        super(name, description);
        subtasks = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Epic otherEpic = (Epic) obj;
        return Objects.equals(this.subtasks, otherEpic.subtasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subtasks);
    }
}
