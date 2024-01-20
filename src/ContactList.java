// Imported classes
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    // Instance variables
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    // Returns the instance variable
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // Adds a single contact to the instance variable
    public void addContact(Person t1) {
        contacts.add(t1);
    }

    // Prints all the contacts out in a list
    public void printContacts() {
        for (int i = 1; i <= contacts.size(); i++) {
            System.out.println(i + ". " + contacts.get(i-1));
        }
    }

    // Sorts the contacts (using bubble sort) using a given parameter
    public void sort(int sortBy) {
        for (int i = 0; i < contacts.size() - 1; i++) {
            for (int k = 0; k < contacts.size() - i - 1; k++) {
                if (sortBy == 0) {
                    if (contacts.get(k).getFirstName().compareTo(contacts.get(k+1).getFirstName()) > 0) {
                        swap(k);
                    }
                } else if (sortBy == 1) {
                    if (contacts.get(k).getLastName().compareTo(contacts.get(k+1).getLastName()) > 0) {
                        swap(k);
                    }
                } else {
                    if (contacts.get(k).getPhoneNumber().compareTo(contacts.get(k+1).getPhoneNumber()) > 0) {
                        swap(k);
                    }
                }
            }
        }
    }

    // Helper function for sort, swaps 2 given indexes
    public void swap(int index) {
        Person tempPerson = contacts.get(index);
        contacts.set(index, contacts.get(index+1));
        contacts.set(index+1, tempPerson);
    }

    // Searches for a specific contact using their first name
    public Person searchByFirstName(String firstName) {
        sort(0);
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equals(firstName)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    // Searches for a specific contact using their last name
    public Person searchByLastName(String lastName) {
        sort(1);
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getLastName().equals(lastName)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    // Searches for a specific contact using their phone number
    public Person searchByPhoneNumber(String phoneNumber) {
        sort(2);
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    // Lists all the students in the contacts list
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

    // Prints out the menu option every loop in the function run()
    public void printMenu() {
        System.out.println("Menu:");
        System.out.println("  1. Add Contact");
        System.out.println("  2. List All Contacts By First Name");
        System.out.println("  3. List All Contacts By Last Name");
        System.out.println("  4. List All Contacts By Phone Number");
        System.out.println("  5. List All Students");
        System.out.println("  6. Search By First Name");
        System.out.println("  7. Search By Last Name");
        System.out.println("  8. Search By Phone Number");
        System.out.println("  0. Exit");
        System.out.println("\nPlease enter your choice below:");
    }

    // Adds a new contact to the list with its specific type
    public void addToList(Scanner sc) {
        System.out.println("Please Enter Below Which Type Of Person You Would Like To Add:");
        System.out.println("  1. Student");
        System.out.println("  2. Teacher");
        String type = sc.nextLine();
        System.out.println("Please Enter Their First Name:");
        String first = sc.nextLine();
        System.out.println("Please Enter Their Last Name:");
        String last = sc.nextLine();
        System.out.println("Please Enter Their Phone Number:");
        String number = sc.nextLine();
        if (type.equals("1")) {
            System.out.println("Please Enter The Students Grade:");
            contacts.add(new Student(first, last, number, Integer.parseInt(sc.nextLine())));
        } else if (type.equals("2")) {
            System.out.println("Please Enter What Class The Teacher Teaches:");
            contacts.add(new Teacher(first, last, number, sc.nextLine()));
        } else {
            contacts.add(new Person(first, last, number));
        }
    }

    // Searches the contacts list for a specific person by calling above functions (given a specific parameter)
    public void searchContacts(Scanner sc, int searchType) {
        Person p1;
        if (searchType == 0) {
            System.out.println("Enter The Persons First Name:");
            p1 = searchByFirstName(sc.nextLine());
        } else if (searchType == 1) {
            System.out.println("Enter The Persons Last Name:");
            p1 = searchByLastName(sc.nextLine());
        } else {
            System.out.println("Enter The Persons Phone Number:");
            p1 = searchByPhoneNumber(sc.nextLine());
        }
        if (p1 == null) {
            System.out.println("\nYour Person Does Not Exist In This Contact List.");
            return;
        }
        System.out.println("\n" + p1);
    }

    // This function calls all other functions above when prompted by user and also runs in a loop until the user exits
    public void run() {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        while (!answer.equals("0")) {
            System.out.println();
            printMenu();
            answer = sc.nextLine();
            if (answer.equals("0")) {
                break;
            } else if (answer.equals("1")) {
                addToList(sc);
            } else if (answer.equals("2")) {
                sort(0);
                System.out.println();
                printContacts();
            } else if (answer.equals("3")) {
                sort(1);
                System.out.println();
                printContacts();
            } else if (answer.equals("4")) {
                sort(2);
                System.out.println();
                printContacts();
            } else if (answer.equals("5")) {
                sort(0);
                System.out.println();
                listStudents();
            } else if (answer.equals("6")) {
                searchContacts(sc, 0);
            } else if (answer.equals("7")) {
                searchContacts(sc, 1);
            } else if (answer.equals("8")) {
                searchContacts(sc, 2);
            }
        }
    }

    // This is a separate function that adds some test data to the contacts list used to test out how the code works
    public static void addTestDataSet(ContactList c) {
        Person s1 = new Student("Kieran", "Pichai", "667", 9);
        Person s2 = new Teacher("Clifford", "Palmer", "668", "English");
        Person s3 = new Student("Angelica", "Chou", "234", 10);
        Person s4 = new Teacher("Ben", "Park", "123", "Math");
        Person s5 = new Student("Geoffrey", "Franc", "488", 11);
        Person s6 = new Teacher("Natalie", "DeCherney", "239", "History");
        c.addContact(s1);
        c.addContact(s2);
        c.addContact(s3);
        c.addContact(s4);
        c.addContact(s5);
        c.addContact(s6);
    }

    // Main function that creates an instance of the ContactList class and runs it
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        addTestDataSet(contactList);
        contactList.run();
    }
}