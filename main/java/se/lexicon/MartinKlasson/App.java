package se.lexicon.MartinKlasson;

import se.lexicon.MartinKlasson.data.People;
import se.lexicon.MartinKlasson.data.TodoItems;
import se.lexicon.MartinKlasson.model.Person;

public class App {

    //Do my test by printing some functionalities out.
    //I know it is far from good. Both funktionality and tests lack.
    //But improve slowly and steadily....
    public static void main( String[] args ) {
        People people  = new People();
        TodoItems todoItem = new TodoItems();

        Person martin = people.createPersonAndAddToArray("Martin", "Klasson");//Martin got id=1
        Person anders = people.createPersonAndAddToArray("Anders", "Claesson");//Anders got id=2

        System.out.println("People array size: " + people.size());
        System.out.println("Person found by id: \n" + people.findById(2));

        System.out.println("\n");
        System.out.println("\n");

        System.out.println(todoItem.createTodoAndAddToArray("clean", false, martin));
        System.out.println(todoItem.createTodoAndAddToArray("wash", false, anders));
        System.out.println(todoItem.createTodoAndAddToArray("Run", false, anders));

        System.out.println("\n");
        System.out.println("\n");


        System.out.println("To do: \t" + todoItem.findById(1).getDescription());
        System.out.println("Assignee : \t" + todoItem.findById(1).getAssignee());

        System.out.println("To do: \t" + todoItem.findById(2).getDescription());
        System.out.println("Assignee : \t" + todoItem.findById(2).getAssignee());

        System.out.println("To do: \t" + todoItem.findById(3).getDescription());
        System.out.println("Assignee : \t" + todoItem.findById(3).getAssignee());

    }
}
