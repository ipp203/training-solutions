package exam03retake02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList {
    private List<Todo> todos = new ArrayList<>();

    public List<Todo> getTodos() {
        return new ArrayList<>(todos);
    }

    public void addTodo(Todo todo) {
        if (todo == null) {
            throw new IllegalArgumentException("Todo is null");
        }
        todos.add(todo);
    }

    public long getNumberOfItemsLeft() {
        return todos.stream()
                .filter(Todo::isNotCompleted)
                .count();
    }

    public List<String> getMostImportantTodosText() {
        return todos.stream()
                .filter(todo -> todo.getPriority() == todos.stream()
                        .mapToInt(Todo::getPriority)
                        .min().getAsInt())
                .map(Todo::getText)
                .collect(Collectors.toList());
    }

    public void deleteCompleted() {
        todos = todos.stream()
                .filter(Todo::isNotCompleted)
                .collect(Collectors.toList());
    }


}
