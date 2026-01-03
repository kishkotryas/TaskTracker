import task.Epic;
import task.Task;

import java.util.HashMap;

public interface TaskManager {
    HashMap<Integer, Epic> getEpics();
    HashMap<Integer, Task> getTasks();
    void createTask();
    void createSubtask();
    void updateTask();
    void displayAllTasks();
    void displayOnlyTasks();
    void displayOnlyEpics();
    void deleteTasks();
    void updateHistory(Task task);
    void getTask(int id);
    void getHistory();
}
