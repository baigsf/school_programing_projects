import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();

        workers.add(new Worker("John", "Smith", "W001", "Mr.", 1985, 25.50));
        workers.add(new Worker("Jane", "Doe", "W002", "Ms.", 1990, 30.00));
        workers.add(new Worker("Bob", "Johnson", "W003", "Mr.", 1978, 22.00));

        workers.add(new SalaryWorker("Alice", "Williams", "S001", "Ms.", 1982, 35.00, 75000.00));
        workers.add(new SalaryWorker("David", "Brown", "S002", "Mr.", 1975, 45.00, 95000.00));
        workers.add(new SalaryWorker("Carol", "Davis", "S003", "Dr.", 1988, 55.00, 120000.00));

        double[] weeklyHours = {40.0, 50.0, 40.0};

        System.out.println("WEEKLY PAYROLL SIMULATION");
        System.out.println();

        for (int week = 0; week < 3; week++) {
            double hours = weeklyHours[week];
            String weekDescription;
            switch (week) {
                case 0:
                    weekDescription = "Week 1 - Normal Week (40 hours)";
                    break;
                case 1:
                    weekDescription = "Week 2 - Crunch Time (50 hours)";
                    break;
                default:
                    weekDescription = "Week 3 - Back to Normal (40 hours)";
            }

            System.out.println(weekDescription);
            System.out.println(String.format("%-25s %-12s %-15s %-15s", "Employee", "Type", "Hours Worked", "Weekly Pay"));
            System.out.println("-------------------------------------------------------------");

            for (Worker worker : workers) {
                String employeeName = worker.formalName();
                String employeeType = (worker instanceof SalaryWorker) ? "Salary" : "Hourly";
                String hoursWorked = String.format("%.1f", hours);
                double weeklyPay = worker.calculateWeeklyPay(hours);
                String pay = String.format("$%,.2f", weeklyPay);

                System.out.println(String.format("%-25s %-12s %-15s %-15s", employeeName, employeeType, hoursWorked, pay));
            }

            System.out.println();
        }

        System.out.println("DETAILED PAY BREAKDOWN");
        System.out.println();

        for (int week = 0; week < 3; week++) {
            double hours = weeklyHours[week];
            String weekDescription;
            switch (week) {
                case 0:
                    weekDescription = "Week 1 (40 hours)";
                    break;
                case 1:
                    weekDescription = "Week 2 (50 hours - Crunch Time)";
                    break;
                default:
                    weekDescription = "Week 3 (40 hours)";
            }

            System.out.println(weekDescription);
            System.out.println("-----------------------------------------------------------");

            for (Worker worker : workers) {
                System.out.println();
                worker.displayWeeklyPay(hours);
            }
            System.out.println();
        }
    }
}
