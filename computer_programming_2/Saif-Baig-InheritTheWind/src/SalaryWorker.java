public class SalaryWorker extends Worker {
    private double annualSalary;

    public SalaryWorker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate, double annualSalary) {
        super(firstName, lastName, ID, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52.0;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        System.out.println("Weekly Pay for " + formalName() + ":");
        System.out.println("  Annual Salary: $" + String.format("%.2f", annualSalary));
        System.out.println("  Weekly Pay (Annual Salary / 52): $" + String.format("%.2f", weeklyPay));
        System.out.println("  Note: Salary workers receive fixed weekly pay regardless of hours worked");
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + annualSalary;
    }

    @Override
    public String toXML() {
        return "<SalaryWorker>\n" +
               "  <ID>" + getID() + "</ID>\n" +
               "  <firstName>" + getFirstName() + "</firstName>\n" +
               "  <lastName>" + getLastName() + "</lastName>\n" +
               "  <title>" + getTitle() + "</title>\n" +
               "  <YOB>" + getYOB() + "</YOB>\n" +
               "  <hourlyPayRate>" + getHourlyPayRate() + "</hourlyPayRate>\n" +
               "  <annualSalary>" + annualSalary + "</annualSalary>\n" +
               "</SalaryWorker>";
    }

    @Override
    public String toJSON() {
        return "{\n" +
               "  \"ID\": \"" + getID() + "\",\n" +
               "  \"firstName\": \"" + getFirstName() + "\",\n" +
               "  \"lastName\": \"" + getLastName() + "\",\n" +
               "  \"title\": \"" + getTitle() + "\",\n" +
               "  \"YOB\": " + getYOB() + ",\n" +
               "  \"hourlyPayRate\": " + getHourlyPayRate() + ",\n" +
               "  \"annualSalary\": " + annualSalary + "\n" +
               "}";
    }

    @Override
    public String toString() {
        return "SalaryWorker{" +
               "firstName='" + getFirstName() + '\'' +
               ", lastName='" + getLastName() + '\'' +
               ", ID='" + getID() + '\'' +
               ", title='" + getTitle() + '\'' +
               ", YOB=" + getYOB() +
               ", hourlyPayRate=" + getHourlyPayRate() +
               ", annualSalary=" + annualSalary +
               '}';
    }
}
