public class Main {
    public static double calculateInterest(double balance, double interestRate, int months) {

        double monthlyInterestRate = interestRate / 100 / 12;


        for (int month = 1; month <= months; month++) {
            double interest = balance * monthlyInterestRate;
            balance += interest;
        }

        return balance;
    }

    public static void main(String[] args) {

        double initialBalance = 5000;


        double interestRate = 17;


        double oneMonthInterest = calculateInterest(initialBalance, interestRate, 1);
        System.out.printf("Interest after one month: $%.2f%n", oneMonthInterest - initialBalance);


        double twoMonthsInterest = calculateInterest(initialBalance, interestRate, 2);
        System.out.printf("Interest after two months: $%.2f%n", twoMonthsInterest - initialBalance);
    }
}
