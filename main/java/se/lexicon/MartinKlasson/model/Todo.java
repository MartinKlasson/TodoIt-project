package se.lexicon.MartinKlasson.model;

import java.util.Objects;

public class Todo {
    private int todoId;
    private String description;
    private boolean done;
    private Person assignee;

    public Todo() {

    }

    public Todo(int todoId, String description) {
        this.todoId = todoId;
        this.description = description;
    }

    public int getTodoId() {
        return todoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", assignee=" + assignee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return done == todo.done &&
                Objects.equals(todoId, todo.todoId) &&
                Objects.equals(description, todo.description) &&
                Objects.equals(assignee, todo.assignee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todoId, description, done, assignee);
    }
}
