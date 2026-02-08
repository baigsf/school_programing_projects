public class Person {
    private String firstName;
    private String lastName;
    private final String ID;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public int getAge() {
        return java.time.Year.now().getValue() - YOB;
    }

    public int getAge(int year) {
        return year - YOB;
    }

    public String toCSV() {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    public String toXML() {
        return "<Person>\n" +
               "  <ID>" + ID + "</ID>\n" +
               "  <firstName>" + firstName + "</firstName>\n" +
               "  <lastName>" + lastName + "</lastName>\n" +
               "  <title>" + title + "</title>\n" +
               "  <YOB>" + YOB + "</YOB>\n" +
               "</Person>";
    }

    public String toJSON() {
        return "{\n" +
               "  \"ID\": \"" + ID + "\",\n" +
               "  \"firstName\": \"" + firstName + "\",\n" +
               "  \"lastName\": \"" + lastName + "\",\n" +
               "  \"title\": \"" + title + "\",\n" +
               "  \"YOB\": " + YOB + "\n" +
               "}";
    }

    @Override
    public String toString() {
        return "Person{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", ID='" + ID + '\'' +
               ", title='" + title + '\'' +
               ", YOB=" + YOB +
               '}';
    }
}
