package ujin.task;

import java.util.*;

public class TaskList {
    protected List<Task> tasks;

    public TaskList(List<Task> li) {
        this.tasks = li;
    }

    public void add(Task t) {
        tasks.add(t);
    }

    public int size() {
        return tasks.size();
    }

    public void delete(int index) {
        tasks.remove(index);
    }

    public Task get(int i) {
        return tasks.get(i);
    }
}