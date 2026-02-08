public class SalaryWorkerTest {
    public static void main(String[] args) {
        System.out.println("=== SalaryWorker Class Test ===\n");

        SalaryWorker salWorker1 = new SalaryWorker("Alice", "Williams", "S001", "Ms.", 1982, 35.00, 75000.00);
        SalaryWorker salWorker2 = new SalaryWorker("David", "Brown", "S002", "Mr.", 1975, 45.00, 95000.00);
        SalaryWorker salWorker3 = new SalaryWorker("Carol", "Davis", "S003", "Dr.", 1988, 55.00, 120000.00);

        System.out.println("Testing SalaryWorker 1: " + salWorker1.formalName());
        System.out.println("Annual Salary: $" + String.format("%.2f", salWorker1.getAnnualSalary()));
        System.out.println("Weekly Pay (40 hours): $" + String.format("%.2f", salWorker1.calculateWeeklyPay(40)));
        System.out.println("Weekly Pay (50 hours): $" + String.format("%.2f", salWorker1.calculateWeeklyPay(50)));
        System.out.println();
        salWorker1.displayWeeklyPay(40);
        System.out.println();

        System.out.println("Testing SalaryWorker 2: " + salWorker2.formalName());
        System.out.println("Annual Salary: $" + String.format("%.2f", salWorker2.getAnnualSalary()));
        System.out.println("Weekly Pay (40 hours): $" + String.format("%.2f", salWorker2.calculateWeeklyPay(40)));
        System.out.println("Weekly Pay (50 hours): $" + String.format("%.2f", salWorker2.calculateWeeklyPay(50)));
        System.out.println();
        salWorker2.displayWeeklyPay(50);
        System.out.println();

        System.out.println("Testing SalaryWorker 3: " + salWorker3.formalName());
        System.out.println("Annual Salary: $" + String.format("%.2f", salWorker3.getAnnualSalary()));
        System.out.println("Weekly Pay (40 hours): $" + String.format("%.2f", salWorker3.calculateWeeklyPay(40)));
        System.out.println("Weekly Pay (50 hours): $" + String.format("%.2f", salWorker3.calculateWeeklyPay(50)));
        System.out.println();
        salWorker3.displayWeeklyPay(60);
        System.out.println();

        System.out.println("=== Testing toCSV() ===");
        System.out.println(salWorker1.toCSV());
        System.out.println();

        System.out.println("=== Testing toXML() ===");
        System.out.println(salWorker1.toXML());
        System.out.println();

        System.out.println("=== Testing toJSON() ===");
        System.out.println(salWorker1.toJSON());
        System.out.println();

        System.out.println("=== Testing toString() ===");
        System.out.println(salWorker1.toString());
    }
}
