import java.util.ArrayList;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Teacher t1) {
        contacts.add(t1);
    }

    public void addContact(Student s1) {
        contacts.add(s1);
    }

    public void printContacts() {
        for (int i = 1; i <= contacts.size(); i++) {
            System.out.println(i + ". " + contacts.get(i-1));
        }
    }

    public void sort(int sortBy) {
        for (int i = 0; i < contacts.size() - 1; i++) {
            for (int k = 0; k < contacts.size() - i - 1; k++) {
                if (sortBy == 0) {
                    if (contacts.get(k).getFirstName().compareTo(contacts.get(k+1).getFirstName()) < 0) {
                        Person tempPerson = contacts.get(k);
                        contacts.set(k, contacts.get(k+1));
                        contacts.set(k+1, tempPerson);
                    }
                } else if (sortBy == 1) {
                    if (contacts.get(k).getLastName().compareTo(contacts.get(k+1).getLastName()) < 0) {
                        Person tempPerson = contacts.get(k);
                        contacts.set(k, contacts.get(k+1));
                        contacts.set(k+1, tempPerson);
                    }
                } else {
                    if (contacts.get(k).getPhoneNumber().compareTo(contacts.get(k+1).getPhoneNumber()) < 0) {
                        Person tempPerson = contacts.get(k);
                        contacts.set(k, contacts.get(k+1));
                        contacts.set(k+1, tempPerson);
                    }
                }
            }
        }
    }

    public Person searchByFirstName(String firstName) {
        sort(0);
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equals(firstName)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        sort(1);
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getLastName().equals(lastName)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        sort(2);
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    public void listStudents() {
        sort(0);
        sort(2);
        int count = 1;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i) instanceof Student) {
                System.out.println(count + ". " + contacts.get(i));
                count++;
            }
        }
    }

    public void run() {
        // FINISH THIS CODE
    }

    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        contactList.run();
    }
}
