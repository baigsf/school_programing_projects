public class Worker extends Person {
    private double hourlyPayRate;

    public Worker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate) {
        super(firstName, lastName, ID, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(hoursWorked, 40);
        double overtimeHours = Math.max(hoursWorked - 40, 0);
        return (regularHours * hourlyPayRate) + (overtimeHours * hourlyPayRate * 1.5);
    }

    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(hoursWorked, 40);
        double overtimeHours = Math.max(hoursWorked - 40, 0);
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        double totalPay = regularPay + overtimePay;

        System.out.println("Weekly Pay for " + formalName() + ":");
        System.out.println("  Regular Hours: " + regularHours + " @ $" + String.format("%.2f", hourlyPayRate) + "/hr = $" + String.format("%.2f", regularPay));
        System.out.println("  Overtime Hours: " + overtimeHours + " @ $" + String.format("%.2f", hourlyPayRate * 1.5) + "/hr = $" + String.format("%.2f", overtimePay));
        System.out.println("  Total Weekly Pay: $" + String.format("%.2f", totalPay));
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + hourlyPayRate;
    }

    @Override
    public String toXML() {
        return "<Worker>\n" +
               "  <ID>" + getID() + "</ID>\n" +
               "  <firstName>" + getFirstName() + "</firstName>\n" +
               "  <lastName>" + getLastName() + "</lastName>\n" +
               "  <title>" + getTitle() + "</title>\n" +
               "  <YOB>" + getYOB() + "</YOB>\n" +
               "  <hourlyPayRate>" + hourlyPayRate + "</hourlyPayRate>\n" +
               "</Worker>";
    }

    @Override
    public String toJSON() {
        return "{\n" +
               "  \"ID\": \"" + getID() + "\",\n" +
               "  \"firstName\": \"" + getFirstName() + "\",\n" +
               "  \"lastName\": \"" + getLastName() + "\",\n" +
               "  \"title\": \"" + getTitle() + "\",\n" +
               "  \"YOB\": " + getYOB() + ",\n" +
               "  \"hourlyPayRate\": " + hourlyPayRate + "\n" +
               "}";
    }

    @Override
    public String toString() {
        return "Worker{" +
               "firstName='" + getFirstName() + '\'' +
               ", lastName='" + getLastName() + '\'' +
               ", ID='" + getID() + '\'' +
               ", title='" + getTitle() + '\'' +
               ", YOB=" + getYOB() +
               ", hourlyPayRate=" + hourlyPayRate +
               '}';
    }
}
