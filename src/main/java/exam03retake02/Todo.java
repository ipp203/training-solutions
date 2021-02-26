package exam03retake02;

public class Todo {

    private final String text;
    private State state;
    private final int priority;

    public Todo(String text, int priority) {
        if (text == null || priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Text is null or priority invalid");
        }
        this.text = text;
        this.priority = priority;
        state = State.NON_COMPLETED;
    }

    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }

    public void complete() {
        state = State.COMPLETED;
    }

    public boolean isNotCompleted() {
        return state == State.NON_COMPLETED;
    }
}
