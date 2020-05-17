package se.lexicon.MartinKlasson.data;

import se.lexicon.MartinKlasson.model.Person;
import se.lexicon.MartinKlasson.model.Todo;
import java.util.Arrays;
import static se.lexicon.MartinKlasson.data.TodoSequencer.nextTodoId;

public class TodoItems {

    private Todo[] todoArray;

    public TodoItems(){
        todoArray = new Todo[0];
    }

    public int size(){
        return todoArray.length;
    }

    public Todo[] findAll(){
        return Arrays.copyOf(todoArray, todoArray.length);
    }
//Why get option about making it void???
    private Todo[] addToArray(final Todo[] target, Todo toAdd) {
        Todo[] newArray = Arrays.copyOf(target, target.length + 1);
        newArray[newArray.length - 1] = toAdd;
        return newArray;
    }

    public Todo findById(int id){
        Todo found = null;
        for(Todo todo : todoArray){
            if(todo.getTodoId() == id){
                found = todo;
                break;
            }
        }
        return found;
    }
    //Unsure about functionality
   public Todo[] findByAssignee(int id){
        Todo[] foundArray = new Todo[0];
       for(Todo todo : todoArray) {
           Person assignee = todo.getAssignee();
           foundArray = findByAssignee(assignee);
//            if(foundArray = findByAssignee(todo.getAssignee()) != null){
//
        }
       return foundArray;
    }

    public Todo[] findByAssignee(Person assignee){
        Todo[] foundArray = new Todo[0];
        for(Todo todo : todoArray){
            if(todo.getAssignee().getId() == assignee.getId()){
            //Todo foundTodo = findById(assignee.getId());
            //if(foundTodo != null){
                foundArray = addToArray(foundArray, todo);
            }//else
                //return null;
        }
        return foundArray;

    }

    public Todo createTodoAndAddToArray(String description, boolean done, Person person){
        Todo todo = new Todo(nextTodoId(), description);
        todo.setDone(done);
        todo.setAssignee(person);
        todoArray = addToArray(todoArray, todo);
        return todo;
    }


    public void clear(){
        todoArray = new Todo[0];
    }

}
