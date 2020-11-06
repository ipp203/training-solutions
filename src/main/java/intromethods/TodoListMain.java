package intromethods;

import java.util.List;

public class TodoListMain {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.addTodo("Programing1");
        todoList.addTodo("Programing2");
        todoList.addTodo("Programing3");
        todoList.addTodo("Programing4");
        todoList.addTodo("Programing2");

        System.out.println(todoList);

        todoList.finishTodos("Programing2");
        System.out.println(todoList.numberOfFinishedTodos());

        List<String> todosToFinish =todoList.todosToFinish();
        System.out.println(todosToFinish.size());

        todoList.finishAllTodos(todosToFinish);
        System.out.println(todoList.numberOfFinishedTodos());

        System.out.println(todoList);
    }
}
