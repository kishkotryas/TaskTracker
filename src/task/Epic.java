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

    public void addSubtaskToEpic (String name, String description) {
        Subtask subtask = new Subtask(name, description);
        if (subtasks.contains(subtask)) {
            System.out.println("Такая подзадача в этом эпике уже есть!");
        } else {
            subtasks.add(subtask);
            System.out.println("Подзадача " + name + " успешно добавлена в эпик " + getName());
        }
    }

    public void displaySubtask () {
        int count = 1;

        for (int i = 0; i < subtasks.size(); i++) {
            var element = subtasks.get(i);
            System.out.println("    " + count + ". Подзадача " + element.getName() + "(ID:" + element.getId() + ")"
                    + ", Описание: " + element.getDescription() + ", Статус: " + element.getStatus());
            ++count;
        }
    }
}
