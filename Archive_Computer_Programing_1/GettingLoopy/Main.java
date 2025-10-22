public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Counting up by 1 from 0 to 30:");
        for (int i = 0; i <= 30; i++)
        {
            System.out.println(i);
        }

        System.out.println("\nCounting down by 1 from 30 to 0:");
        for (int i = 30; i >= 0; i--)
        {
            System.out.println(i);
        }

        System.out.println("\nCounting up by 3 from 0 to 18:");
        for (int i = 0; i <= 18; i += 3)
        {
            System.out.println(i);
        }

        System.out.println("\nCounting down by 2 from 10 to 0:");
        for (int i = 10; i >= 0; i -= 2)
        {
            System.out.println(i);
        }


        System.out.println("\nCreating the figure:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Task 6: Nested loop for figure 2");
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("Task 7: Nested loop for figure 3");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }



    }
}
