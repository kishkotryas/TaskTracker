import task.Task;

import java.util.ArrayList;

public class InMemoryHistoryManager implements HistoryManager{
    public final static int MAX_HISTORY_SIZE = 10;
    private ArrayList<Task> history = new ArrayList<>();

    @Override
    public void add(Task task) {
        if (history.size() == MAX_HISTORY_SIZE) {
            history.remove(0);
        }
        history.add(task);
    }

    @Override
    public ArrayList<Task> getHistory() {
        return history;
    }
}
