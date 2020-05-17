package se.lexicon.MartinKlasson.data;

import se.lexicon.MartinKlasson.model.Person;
import java.util.Arrays;
import static se.lexicon.MartinKlasson.data.PersonSequencer.nextPersonId;

public class People {

    private Person[] personArray;

    public People() {
        personArray = new Person[0];
    }

    public int size() {
        return personArray.length;
    }

    public Person[] findAll() {
        return Arrays.copyOf(personArray, personArray.length);

    }

    public Person findById(int id) {
        Person found = null;
        for (Person person : personArray) {
            if (person.getId() == id) {
                found = person;
                break;
            }
        }
        return found;
    }

    //Not in assignment....
    public Person[] findByLastName(String lastName) {
        Person[] result = new Person[0];
        for (Person person : personArray) {
            if (person.getLastName().equalsIgnoreCase(lastName)) {
                result = addToArray(result, person);
            }
        }
        return result;
    }

    //Not in assignment....
    public Person update(Person updatedPerson) {
        Person toUpdate = findById(updatedPerson.getId());
        if (toUpdate == null) {
            return null;
        }
        toUpdate.setFirstName(updatedPerson.getFirstName());
        toUpdate.setLastName(updatedPerson.getLastName());
        return toUpdate;
    }

    public void clear() {
        personArray = new Person[0];
    }

    public Person createPersonAndAddToArray(String firstName, String lastName) {
        Person person = new Person(nextPersonId(), firstName, lastName);
        personArray = addToArray(personArray, person);
        return person;
    }

    private Person[] addToArray(final Person[] target, Person toAdd) {
        Person[] newArray = Arrays.copyOf(target, target.length + 1);
        newArray[newArray.length - 1] = toAdd;
        return newArray;
    }
}
