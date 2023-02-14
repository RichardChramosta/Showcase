import java.util.Arrays;
public class MultiRegresion {
    public static void main(String[] args) {

        double X[] = { 3,4,5,6,2 };
        double X2[] = { 8,5,7,3,1};
        double Y[] = { -3.7,3.5,2.5,11.5,5.7};


        multtipleRegLine(X,X2, Y);

    }

    private static void multtipleRegLine(double[] x,double[] x2, double[] y) {

        double a = calculateA(x,x2,y);
        double b = calculateB(x,x2,y);

        double n = x.length;

        double meanX =Arrays.stream(x).sum() / n;
        double meanY =Arrays.stream(y).sum() / n;
        double meanX2 =Arrays.stream(x2).sum() / n;
        double c = meanY -(b*meanX) -(a*meanX2);
        System.out.print("Y = ");
        System.out.printf("%.3f", a);
        System.out.print("*X2");
        System.out.print(" + ");
        System.out.printf("%.3f", b);
        System.out.print("*X");
        System.out.print(" + ");
        System.out.printf("%.3f", c);

    }
    private static double calculateA(double[] x, double[] x2,double[] y) {

        double n = x.length;

        double sumOfArrayX2 = Arrays.stream(x2).sum();
        double sumOfArrayX = Arrays.stream(x).sum();
        double sumOfArrayY = Arrays.stream(y).sum();
        double sumOfX2andY = 0;
        double sumOfXandY = 0;
        double sumOfX2andX = 0;
        double sumOfSsquareX2 = 0;
        double sumOfSquareX = 0;


        for (int i = 0; i < n; i++) {
            sumOfSsquareX2 += x2[i]*x2[i];
            sumOfSquareX += x[i]*x[i];
            sumOfX2andY += x2[i]*y[i];
            sumOfXandY += x[i]*y[i];
            sumOfX2andX += x2[i]*x[i];
        }
        // a = aup1 * aup2  -  aup3 * aup4  /  adown1 * adown2  -  adown3 * adown4
        // double aup0 =(sumOfSsquareX2 *(sumOfSsquareX2-((sumOfArrayX2*sumOfArrayY)/n)))-((sumOfX2andX-((sumOfArrayX*sumOfArrayX2)/n))*sumOfX2andY-((sumOfArrayX2*sumOfArrayY)/n));
        // double aup1 = sumOfSsquareX2 -((sumOfArrayX2)/n);
        double aup1 = sumOfSquareX -((sumOfArrayX*sumOfArrayX)/n);
        double aup2 =sumOfX2andY-((sumOfArrayX2*sumOfArrayY)/n);
        double aup3 =(sumOfX2andX-((sumOfArrayX*sumOfArrayX2)/n));
        double aup4 =sumOfXandY-((sumOfArrayX*sumOfArrayY)/n);

        double adown1 = sumOfSquareX -((sumOfArrayX*sumOfArrayX)/n);
        double adown2 = sumOfSsquareX2 -((sumOfArrayX2*sumOfArrayX2)/n);
        double adown3 =(sumOfX2andX-((sumOfArrayX*sumOfArrayX2)/n));
        double adown4 =(sumOfX2andX-((sumOfArrayX*sumOfArrayX2)/n));
        double a = ((aup1 * aup2)  -  (aup3 * aup4) ) / (( adown1 * adown2) -  (adown3 * adown4) );

        return a;
    }
    private static double calculateB(double[] x,double[] x2, double[] y) {

        double n = x.length;

        double sumOfArrayX2 = Arrays.stream(x2).sum();
        double sumOfArrayX = Arrays.stream(x).sum();
        double sumOfArrayY = Arrays.stream(y).sum();
        double sumOfX2andY = 0;
        double sumOfXandY = 0;
        double sumOfX2andX = 0;
        double sumOfSsquareX2 = 0;
        double sumOfSquareX = 0;
        for (int i = 0; i < n; i++) {
            sumOfSsquareX2 += x2[i]*x2[i];
            sumOfSquareX += x[i]*x[i];
            sumOfX2andY += x2[i]*y[i];
            sumOfXandY += x[i]*y[i];
            sumOfX2andX += x2[i]*x[i];
        }
        double bup1 = sumOfSsquareX2 -((sumOfArrayX2*sumOfArrayX2)/n);
        double bup2 =sumOfXandY-((sumOfArrayX*sumOfArrayY)/n);
        double bup3 =(sumOfX2andX-((sumOfArrayX*sumOfArrayX2)/n));
        double bup4 =sumOfX2andY-((sumOfArrayX2*sumOfArrayY)/n);

        double bdown1 = sumOfSquareX -((sumOfArrayX*sumOfArrayX)/n);
        double bdown2 = sumOfSsquareX2 -((sumOfArrayX2*sumOfArrayX2)/n);
        double bdown3 =(sumOfX2andX-((sumOfArrayX*sumOfArrayX2)/n));
        double bdown4 =(sumOfX2andX-((sumOfArrayX*sumOfArrayX2)/n));
        double b = (((bup1*bup2)-(bup3*bup4))/((bdown1*bdown2)-(bdown3*bdown4)));

        return b;
    }
}
