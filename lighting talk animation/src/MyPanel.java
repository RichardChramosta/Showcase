import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyPanel extends JPanel implements ActionListener{
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 240;
    Image eagle;
    Image eagle4;
    Image eagle2;
    Image eagle3;
    Image eagleS;
    Image eaglego1;
    Image eaglego2;
    Image eaglego3;
    Image eaglego4;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x =-100;
    int x2 =0;

    int y =0;
    int helper = 100;



    MyPanel() {
        this.setPreferredSize( new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground((Color.BLACK));
        backgroundImage = new ImageIcon("src/background1.jpg").getImage();

        eagle = new ImageIcon("src/Eflying1.png").getImage();
        eagle2 = new ImageIcon("src/Eflying2.png").getImage();
        eagle3 = new ImageIcon("src/Eflying3.png").getImage();
        eagle4 = new ImageIcon("src/Eflying4.png").getImage();
        eaglego1 = new ImageIcon("src/Egoup1.png").getImage();
        eaglego2 = new ImageIcon("src/Egoup2.png").getImage();
        eaglego3 = new ImageIcon("src/Egoup3.png").getImage();
        eaglego4 = new ImageIcon("src/Egoup4.png").getImage();
        eagleS = new ImageIcon("src/Estanding.png").getImage();
        timer = new Timer(10,this);
        timer.start();
    }

    public void paint(Graphics g){

        super.paint(g);
        Graphics g2D = (Graphics2D) g;

        g2D.drawImage(backgroundImage, x2 , y, null);
        g2D.drawImage(backgroundImage, 678+x2 , y, null);
        if (x>=-100 && x<-10){
            g2D.drawImage(eagleS, 100 , 90, null);
        }
        if (x>=-10 && x<0){
            g2D.drawImage(eaglego1, 110 , 80, null);
        }
        if (x>=0 && x<10){
            g2D.drawImage(eaglego2, 120 , 70, null);
        }  if (x>=10 && x<20){
            g2D.drawImage(eaglego3, 120 , 70, null);
        }  if (x>=20 && x<30){
            g2D.drawImage(eaglego4, 130 , 60, null);
        }

        if ( (x>=30 && x<=40) || (x>70&& x<=80)|| (x>110&& x<=120) || (x>150&& x<=160)|| (x>190&& x<=200) || (x>230&& x<=240)|| (x>270&& x<=280) || (x>310&& x<=320)|| (x>350&& x<=360) || (x>390&& x<=400) || (x>430 && x<=440) || (x>470&& x<=480)|| (x>510&& x<=520) || (x>550&& x<=560)|| (x>590&& x<=600) || (x>630&& x<=640)|| (x>670&& x<=680)){
            g2D.drawImage(eagle, 130 , 60, null);
        }

        if (  (x>=40 && x<=50) ||(x>80&& x<=90)|| (x>120&& x<=130) || (x>160&& x<=170)|| (x>200&& x<=210) || (x>240&& x<=250)|| (x>280&& x<=290) || (x>320&& x<=330)|| (x>360&& x<=370) || (x>400&& x<=410)|| (x>440 && x<=450) || (x>480&& x<=490)|| (x>520&& x<=530) || (x>560&& x<=570)|| (x>600&& x<=610) || (x>640&& x<=650)) {
            g2D.drawImage(eagle2, 130 , 60, null);
        }
        if ( (x>50 && x<=60) || (x>90&& x<=100)|| (x>130&& x<=140) || (x>170&& x<=180)|| (x>210&& x<=220) || (x>250&& x<=260)|| (x>290&& x<=300) || (x>330&& x<=340)|| (x>370&& x<=380) || (x>410&& x<=420)|| (x>450 && x<=460) || (x>490&& x<=500)|| (x>530&& x<=540) || (x>570&& x<=580)|| (x>610&& x<=620) || (x>650&& x<=660)) {
            g2D.drawImage(eagle3, 130 , 60, null);
        }
        if ( (x>60 && x<=70) || (x>100&& x<=110)|| (x>140&& x<=150) || (x>180&& x<=190)|| (x>220&& x<=230) || (x>260&& x<=270)|| (x>300&& x<=310) || (x>340&& x<=350)|| (x>380&& x<=390) || (x>420&& x<=430)|| (x>460 && x<=470) || (x>500&& x<=510)|| (x>540&& x<=550) || (x>580&& x<=590)|| (x>620&& x<=630) || (x>660&& x<=670))  {
            g2D.drawImage(eagle4, 130 , 60, null);
        }
//        if (x == 0 || (x>30 && x<=40) || (x>70&& x<=80)|| (x>110&& x<=120) || (x>150&& x<=160)|| (x>190&& x<=200) || (x>230&& x<=240)|| (x>270&& x<=280) || (x>310&& x<=320)|| (x>350&& x<=360) || (x>390&& x<=400) || (x>430 && x<=440) || (x>470&& x<=480)|| (x>510&& x<=520) || (x>550&& x<=560)|| (x>590&& x<=600) || (x>630&& x<=640)|| (x>670&& x<=680)){
//            g2D.drawImage(eagle, 130 , 60, null);
//        }
//
//        if ((x > 0 &&  x<=10) || (x>40 && x<=50) || (x>80&& x<=90)|| (x>120&& x<=130) || (x>160&& x<=170)|| (x>200&& x<=210) || (x>240&& x<=250)|| (x>280&& x<=290) || (x>320&& x<=330)|| (x>360&& x<=370) || (x>400&& x<=410)|| (x>440 && x<=450) || (x>480&& x<=490)|| (x>520&& x<=530) || (x>560&& x<=570)|| (x>600&& x<=610) || (x>640&& x<=650)) {
//            g2D.drawImage(eagle2, 130 , 60, null);
//        }
//        if ((x > 10 &&  x<=20) || (x>50 && x<=60) || (x>90&& x<=100)|| (x>130&& x<=140) || (x>170&& x<=180)|| (x>210&& x<=220) || (x>250&& x<=260)|| (x>290&& x<=300) || (x>330&& x<=340)|| (x>370&& x<=380) || (x>410&& x<=420)|| (x>450 && x<=460) || (x>490&& x<=500)|| (x>530&& x<=540) || (x>570&& x<=580)|| (x>610&& x<=620) || (x>650&& x<=660)) {
//            g2D.drawImage(eagle3, 130 , 60, null);
//        }
//        if ((x > 20 &&  x<=30) || (x>60 && x<=70) || (x>100&& x<=110)|| (x>140&& x<=150) || (x>180&& x<=190)|| (x>220&& x<=230) || (x>260&& x<=270)|| (x>300&& x<=310) || (x>340&& x<=350)|| (x>380&& x<=390) || (x>420&& x<=430)|| (x>460 && x<=470) || (x>500&& x<=510)|| (x>540&& x<=550) || (x>580&& x<=590)|| (x>620&& x<=630) || (x>660&& x<=670))  {
//            g2D.drawImage(eagle4, 130 , 60, null);
//        }


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        x = x + xVelocity;
        if (helper > 0) {
            helper--;
        }else {

            helper =-5;
            x2 = x2 - xVelocity;
        }
        if (x >678){x2=0;
        x=30;}
        repaint();
    }
}

