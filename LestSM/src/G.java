import processing.core.PApplet;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class G extends PApplet {
    public void settings(){
        size(500,500);
    }
    public void setup(){}
    public void draw(){

        line(20,480,480,480);
        line(20,20,20,480);

        text("0",10,490);

        double Xpoints[] = { 3,4,5,6,2 };
        double X2points[] = { 8,5,7,3,1};
        double Ypoints[] = { -3.7,3.5,2.5,11.5,5.7};


        double X[] = { 1,2,3,4,5,6,7,8};
        double X2[] = { 8,7,6,5,4,3,2,1};
        double Y[] = new double[X.length];

        for (int i = 0; i < Xpoints.length; i++) {
            color(250);
            // color(55,55,250);
            double l1 = 50+(Xpoints[i]*50);
            double l3 = 50+(X2points[i]*50);
            double l2 =height-50-Ypoints[i];
            ellipse((float) l1, (float) l2, 4,4);
            color(12);
            // color(55,255,250);
            ellipse((float) l3, (float) l2, 4,4);
        }
        for (int i = 0; i < X.length; i++) {
            Y[i] =  ((-1.672*X[i]) + 2.282*X2[i] +2.8);


            if (i > 0) {




                color(155,155,100);
                int x1 = (int) (50+(X[i-1]*50));
                int x2 = (int) (height-50-Y[i-1]);
                int x3 = (int) (50+(X[i]*50));
                int x4 = (int) (height-50-Y[i]);
                line(x1,x2, x3,  x4);
                //g1.drawLine((int) (mar+(X[i-1]*50)), (int) (height-mar-Y[i-1]), (int) (mar+(X[i]*50)), (int) (height-mar-Y[i]));

            }
        }







    }

    public static void main(String[] args) {
        PApplet.main("G");

    }
}