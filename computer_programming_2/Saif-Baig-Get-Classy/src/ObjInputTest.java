public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();
        System.out.println("--- Testing SafeInputObj ---");

        String name = input.getNonZeroLenString("Enter your name");
        int age = input.getRangedInt("Enter your age", 1, 100);
        double salary = input.getDouble("Enter your desired salary");
        boolean confirm = input.getYNConfirm("Is this correct?");

        System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary + ", Confirmed: " + confirm);
    }
}