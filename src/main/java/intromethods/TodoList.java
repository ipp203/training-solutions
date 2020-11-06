package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Todo> todos = new ArrayList<>();

    public void addTodo(String caption) {
        todos.add(new Todo(caption));
    }

    public void finishTodos(String caption) {
        for (Todo todo : todos) {
            if (todo.getCaption().equals(caption)) {
                todo.finish();
            }
        }
    }

    public void finishAllTodos(List<String> todosToFinish) {
        for (Todo todo : todos) {
            for (String str : todosToFinish) {
                if (todo.getCaption().equals(str)) {
                    todo.finish();
                }
            }
        }
    }

    public List<String> todosToFinish(){
        List<String> listOfTodos = new ArrayList<>();
        for (Todo todo: todos) {
            if (!todo.isFinished()){
                listOfTodos.add(todo.getCaption());
            }
        }
        return listOfTodos;
    }

    public int numberOfFinishedTodos(){
        int num = 0;
        for (Todo todo:todos) {
            if (todo.isFinished())
                num++;
        }
        return num;
    }

    @Override
    public String toString() {
        return todos.toString();
    }
}
