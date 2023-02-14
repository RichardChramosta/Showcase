// Java program to find the
// regression line

import java.util.Arrays;

public class GFG {

    // Function to calculate b
    private static double calculateB(
            double[] x, double[] y)
    {
        double n = x.length;

        // sum of array x
        double sx = Arrays.stream(x).sum();

        // sum of array y
        double sy = Arrays.stream(y).sum();

        // for sum of product of x and y
        double sxsy = 0.0;

        // sum of square of x
        double sx2 = 0.0;
        for (int i = 0; i < n; i++) {
            sxsy += x[i] * y[i];
            sx2 += x[i] * x[i];
        }
        double b = (double)(n * sxsy - sx * sy)
                / (n * sx2 - sx * sx);

        return b;
    }

    // Function to find the
    // least regression line
    public static void leastRegLine(double X[], double Y[])
    {

        // Finding b
        double b = calculateB(X, Y);

        double n = X.length;
        double meanX = Arrays.stream(X).sum() / n;
        double meanY = Arrays.stream(Y).sum() / n;

        // calculating a
        double a = meanY - b * meanX;

        // Printing regression line
        System.out.println("Regression line:");
        System.out.print("Y = ");
        System.out.printf("%.3f", a);
        System.out.print(" + ");
        System.out.printf("%.3f", b);
        System.out.print("*X");
    }

    // Driver code
    public static void main(String[] args)
    {
        // statistical data
      //  int X[] = { 95, 85, 80, 70, 60 };
       // int Y[] = { 90, 80, 70, 65, 60 };
       // double X[] = { 1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,11.0,12.0,13.0 };
        //double Y[] = { 14.0,18.0,28.0,44.0,66.0,94.0,128.0,168.0,214.0,266.0,324.0,388.0,458.0};
         double X[] = { 54,60,73,80,80,80,82,82,84,85,85,90,94,94,99,100};

         double Y[] = { 32,47,69,61,68,68,75,86,71,78,75,99,96,89,94,132};

        leastRegLine(X, Y);
    }
}
