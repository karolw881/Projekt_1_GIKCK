import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fraktal extends JFrame implements ActionListener {

    Button button_back_frame;

    Fraktal(){

        // Utworzenie Buttona ktorego akcją jest powrot do menu
        button_back_frame = new Button("BACK <-");
        button_back_frame.setFocusable(false);
        button_back_frame.setBounds(1,1,100,50);
        button_back_frame.addActionListener(this);

        // Utworzenie GUI
        this.add(button_back_frame);
        this.setTitle("Fraktal Koch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(1500,800);
        this.setVisible(true);
    }

    // Metoda rysujaca grafike
    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.cyan);
        koch_snowflake(g2D , 5 , 600 );
        g2D.setColor(Color.red);
        koch_snowflake(g2D , 6 , 900 );
        g2D.setColor(Color.orange);
        koch_snowflake(g2D , 7 , 300 );
        g2D.setColor(Color.GREEN);
        koch_snowflake(g2D , 8 , 000 );
        g2D.setColor(Color.GREEN);
    }

    // /metoda ktora wykorzystuje krzywe by narysowac jeden snowflake(platek)
    private void koch_snowflake(Graphics g , int level_x , int x_x ){
        Rysuj_krzywa(g,100 + x_x  ,150,0,300,level_x);
        Rysuj_krzywa(g,400+ x_x ,150,1.55,300,level_x);
        Rysuj_krzywa(g,400 + x_x  ,450,3.15,300,level_x);
        Rysuj_krzywa(g,100 + x_x ,450,4.70,300,level_x);
    }

    // Algorytm rekurencyjny rysowania krzywej  Kocha , troche wspomagane internetem , strony nie pamietam
    private void Rysuj_krzywa(Graphics g, double x1, double y1, double kat_1, double dlugosc_boku, int i) {
        double x2, y2, kat_2, x3, y3, kat_3, x4, y4;
        if (i>1) {
            dlugosc_boku /= 3;
            i -= 1;
            Rysuj_krzywa(g, x1,y1, kat_1, dlugosc_boku, i);
            x2 = x1+dlugosc_boku*Math.cos(kat_1);
            y2 = y1+dlugosc_boku*Math.sin(kat_1);
            kat_2 = kat_1-Math.PI/3;
            Rysuj_krzywa(g, x2,y2, kat_2, dlugosc_boku, i);
            x3 = x2 + dlugosc_boku*Math.cos(kat_2);
            y3 = y2 + dlugosc_boku*Math.sin(kat_2);
            kat_3 = kat_1+Math.PI/3;
            Rysuj_krzywa(g, x3,y3, kat_3, dlugosc_boku, i );
            x4 = x3+dlugosc_boku*Math.cos(kat_3);
            y4 = y3+dlugosc_boku*Math.sin(kat_3);
            Rysuj_krzywa(g, x4,y4, kat_1, dlugosc_boku, i);
        }
        else g.drawLine((int)x1,(int)y1,(int)(x1+dlugosc_boku*Math.cos(kat_1)),(int)(y1+dlugosc_boku*Math.sin(kat_1)));

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button_back_frame){
            this.dispose();
            new My_frame();
        }
    }
}

