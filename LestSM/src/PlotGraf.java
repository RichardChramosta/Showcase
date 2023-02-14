
import java.awt.*;
import javax.sound.sampled.Line;
import javax.swing.*;
        import java.awt.geom.*;
public class PlotGraf extends JPanel{
    int[] coordinates={100,20};
    int mar=50;
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g1=(Graphics2D)g;
        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        int width=getWidth();
        int height=getHeight();
        g1.draw(new Line2D.Double(mar,mar,mar,height-mar));
       // g1.draw(new Line2D.Double(mar,height-mar,width-mar,height-mar));
        g1.draw(new Line2D.Double(mar,height-mar,width-mar,height-mar));
        //double scale=(double)(height-2*mar)/getMax();
        //double x=(double)(width-2*mar)/(coordinates.length-1);

        g1.drawString("y=max",mar-10,mar);
        g1.drawString("0",mar-10,height-mar);
        g1.drawString("x=max",width-mar,height-mar-10);

//         double Xpoints[] = { 54,60,73,80,80,80,82,82,84,85,85,90,94,94,99,100};
//        double Ypoints[] = { 32,47,69,61,68,68,75,86,71,78,75,99,96,89,94,132};
//        double X[] = new double[100];
//        for (int i = 0; i < X.length; i++) {
//            X[i] = 54+i;
//        }

        //double X[] = { 1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        double X[] = new double[70];
        double increament = 1;
        for (int i = 0; i < X.length; i++) {
            increament += 0.1;
            X[i] = increament;
        }

        double Y[] = new double[X.length];
//        for (int i = 0; i < Xpoints.length; i++) {
//            g1.setPaint(Color.RED);
//            g1.fill(new Ellipse2D.Double(mar+(Xpoints[i]),height-mar-Ypoints[i], 4,4));
//        }

        for (int i = 0; i < X.length; i++) {
             Y[i] = (3*X[i]*X[i]) -(5*X[i]) + 16 ;
            //Y[i] = 1.651 * X[i]  - 58.941;

            g1.setPaint(Color.RED);
            g1.fill(new Ellipse2D.Double(mar+(X[i]*50),height-mar-Y[i], 4,4));

            if (i > 0) {
                g1.setPaint(Color.BLACK);
                // g1.drawLine((int) (mar+(X[i-1])), (int) (height-mar-Y[i-1]), (int) (mar+(X[i])), (int) (height-mar-Y[i]));
               g1.drawLine((int) (mar+(X[i-1]*50)), (int) (height-mar-Y[i-1]), (int) (mar+(X[i]*50)), (int) (height-mar-Y[i]));


            }
        }



        // double Y[] = { 62,67,69,61,62,68,67,77,65,65,67,55,67,62,67,68};
    }
    private int getMax(){
        int max=-Integer.MAX_VALUE;
        for(int i=0;i<coordinates.length;i++){
            if(coordinates[i]>max)
                max=coordinates[i];

        }return max;
    }

    public static void main(String args[]){
        JFrame frame =new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PlotGraf());
        frame.setSize(600,400);
        frame.setLocation(200,200);
        frame.setVisible(true);
    }
}