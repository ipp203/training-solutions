package interfaces.simplethread;

import java.util.List;

public class SimpleThread implements Runnable {
    List<String> tasks;

    public SimpleThread(List<String> tasks) {
        this.tasks = tasks;
    }

    public List<String> getTasks() {
        return tasks;
    }

    @Override
    public void run() {
        while (nextStep()) {

        }
    }

    private boolean nextStep() {
        if (tasks.size() > 0) {
            tasks.remove(tasks.get(tasks.size() - 1));
        }
        return tasks.size() > 0;
    }
}
