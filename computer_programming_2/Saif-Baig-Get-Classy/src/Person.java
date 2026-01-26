import java.util.Calendar;

public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    /**
     * Full Constructor
     * @param firstName First Name
     * @param lastName Last Name
     * @param ID ID Number
     * @param title Title (Mr., Mrs., etc)
     * @param YOB Year of Birth (1940-2010)
     */
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        setYOB(YOB);
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getID() { return ID; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getYOB() { return YOB; }

    /**
     * Sets YOB with validation
     * @param YOB year of birth (1940-2010)
     */
    public void setYOB(int YOB) {
        if (YOB < 1940 || YOB > 2010) throw new IllegalArgumentException("YOB must be 1940-2010");
        this.YOB = YOB;
    }

    /**
     * @return Firstname Lastname
     */
    public String fullName() { return firstName + " " + lastName; }

    /**
     * @return Title Firstname Lastname
     */
    public String formalName() { return title + " " + fullName(); }

    /**
     * @return Age based on current year
     */
    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - YOB;
    }

    /**
     * @param year the year to calculate age from
     * @return Age based on specific year
     */
    public int getAge(int year) { return year - YOB; }

    /**
     * @return CSV formatted string
     */
    public String toCSV() { return String.join(",", ID, firstName, lastName, title, String.valueOf(YOB)); }

    /**
     * @return JSON formatted string
     */
    public String toJSON() {
        return String.format("{\"ID\":\"%s\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"title\":\"%s\",\"YOB\":%d}", ID, firstName, lastName, title, YOB);
    }

    /**
     * @return XML formatted string
     */
    public String toXML() {
        return String.format("<Person><ID>%s</ID><FirstName>%s</FirstName><LastName>%s</LastName><Title>%s</Title><YOB>%d</YOB></Person>", ID, firstName, lastName, title, YOB);
    }

    @Override
    public String toString() { return toCSV(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB && ID.equals(person.ID) && firstName.equals(person.firstName) && lastName.equals(person.lastName);
    }
}