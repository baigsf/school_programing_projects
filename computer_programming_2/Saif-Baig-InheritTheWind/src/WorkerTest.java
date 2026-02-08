public class WorkerTest {
    public static void main(String[] args) {
        System.out.println("=== Worker Class Test ===\n");

        Worker worker1 = new Worker("John", "Smith", "W001", "Mr.", 1985, 25.50);
        Worker worker2 = new Worker("Jane", "Doe", "W002", "Ms.", 1990, 30.00);
        Worker worker3 = new Worker("Bob", "Johnson", "W003", "Mr.", 1978, 20.00);

        System.out.println("Testing Worker 1: " + worker1.formalName());
        System.out.println("Hourly Rate: $" + worker1.getHourlyPayRate());
        System.out.println("40-hour week pay: $" + String.format("%.2f", worker1.calculateWeeklyPay(40)));
        System.out.println("50-hour week pay: $" + String.format("%.2f", worker1.calculateWeeklyPay(50)));
        System.out.println();
        worker1.displayWeeklyPay(50);
        System.out.println();

        System.out.println("Testing Worker 2: " + worker2.formalName());
        System.out.println("Hourly Rate: $" + worker2.getHourlyPayRate());
        System.out.println("40-hour week pay: $" + String.format("%.2f", worker2.calculateWeeklyPay(40)));
        System.out.println("50-hour week pay: $" + String.format("%.2f", worker2.calculateWeeklyPay(50)));
        System.out.println();
        worker2.displayWeeklyPay(45);
        System.out.println();

        System.out.println("Testing Worker 3: " + worker3.formalName());
        System.out.println("Hourly Rate: $" + worker3.getHourlyPayRate());
        System.out.println("40-hour week pay: $" + String.format("%.2f", worker3.calculateWeeklyPay(40)));
        System.out.println("50-hour week pay: $" + String.format("%.2f", worker3.calculateWeeklyPay(50)));
        System.out.println();
        worker3.displayWeeklyPay(40);
        System.out.println();

        System.out.println("=== Testing toCSV() ===");
        System.out.println(worker1.toCSV());
        System.out.println();

        System.out.println("=== Testing toXML() ===");
        System.out.println(worker1.toXML());
        System.out.println();

        System.out.println("=== Testing toJSON() ===");
        System.out.println(worker1.toJSON());
        System.out.println();

        System.out.println("=== Testing toString() ===");
        System.out.println(worker1.toString());
    }
}
