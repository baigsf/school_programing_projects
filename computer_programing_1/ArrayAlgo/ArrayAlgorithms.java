import java.util.Random;

public class ArrayAlgorithms
{
    public static void main(String[] args)

    {
        final int SIZE = 100;
        Random rnd = new Random();
        int[] intVals = new int[SIZE];
        double[] doubleVals = new double[SIZE];

        int sumOfInts = 0;
        int intMin, intMax;
        double doubleMin, doubleMax;
        double aveInts = 0;
        double soumOfDoubles = 0;
        double avgOfDoubles = 0;

        // Filling an array

        for(int i=0; i < intVals.length; i++)
        {
            intVals[i] = rnd.nextInt(101);
        }

        for(int v: intVals)
                System.out.print(v + "\t");

        System.out.println();

         // Sum the array
        for(int v: intVals)
            sumOfInts += v;
        aveInts = (double) sumOfInts / intVals.length; // double = int / int integer division


        System.out.println("The sum is " + sumOfInts);
        System.out.println("The average is " + aveInts);

        //Find the min element
        intMin = intVals[0];
        intMax = intVals[0];

        for(int v: intVals)
        {
            if(v < intMin)
                intMin =v;
            if(v > intMax)
                intMax =v;
        }
        System.out.println("The min is " + intMin);
        System.out.println("The max is " + intMax);



    }
}
