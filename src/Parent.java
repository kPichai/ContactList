public class Parent extends Person {
    private String childsName;

    public Parent(String firstName, String lastName, String phoneNumber, String childsName) {
        super(firstName, lastName, phoneNumber);
        this.childsName = childsName;
    }

    public String getChildsName() {
        return childsName;
    }

    public void setChildsName(String childsName) {
        this.childsName = childsName;
    }

    public String toString() {
        return super.toString() + ", Name of Child: " + childsName;
    }
}
