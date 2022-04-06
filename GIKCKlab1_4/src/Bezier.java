import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bezier extends JFrame implements ActionListener {

    private static final int startx = 350  ;
    private static  final int starty = 150;
    private  double xt , yt ;
    JButton button_back_frame;

    Bezier(){
        //Inicjalizacja buttona
        button_back_frame = new JButton("BACK <----");
        button_back_frame.setForeground(Color.BLUE);
        button_back_frame.setBackground(Color.magenta);
        button_back_frame.setBounds(100,200,200,100);
        button_back_frame.addActionListener(this);
        button_back_frame.setFocusable(false);

        //Stworzenie Gui
        this.add(button_back_frame);
        this.setTitle("Bezier !!!!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        //this.setLayout(new BorderLayout(10,10));
        this.setResizable(false);
        this.setSize(900,800);
        this.setVisible(true);

    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.cyan);
        rysuj_bezier(g2D);
    }
    //Rysowanie poszczegolnych krzywych
    private void rysuj_bezier(Graphics g ) {
        drawCurve(g, 28, 22, 27, 7, 40, 464, 29, 467);
        drawCurve(g,28, 22, 27, 7, 40, 464, 29, 467);
        drawCurve(g,29, 467, 2, 474, 68, 489, 71, 467);
        drawCurve(g,71, 467, 77, 417, 76, 257, 73, 254);
        drawCurve(g,73, 254, 52, 230, 186, 213, 231, 469);
        drawCurve(g,226, 470, 227, 477, 256, 420, 260, 413);
        drawCurve(g,260, 413, 276, 385, 317, 317, 302, 314);
        drawCurve(g,302, 314, 268, 308, 364, 451, 358, 465);
        drawCurve(g,358, 465, 352, 479, 467, 207, 478, 210);
        drawCurve(g,478, 210, 492, 214, 469, 211, 460, 199);
        drawCurve(g,460, 199, 451, 187, 372, 399, 362, 411);
        drawCurve(g,362, 411, 352, 423, 285, 256, 297, 247);
        drawCurve(g,297, 247, 328, 225, 260, 377, 241, 408);
        drawCurve(g,241, 408, 233, 421, 209, 227, 124, 223);
        drawCurve(g,123, 223, 105, 222, 172, 215, 248, 26);
        drawCurve(g,248, 26, 254, 12, 235, 22, 188, 19);
        drawCurve(g,188, 19, 187, 19, 176, 171, 76, 217);
        drawCurve(g,76, 217, 62, 223, 79, 42, 70, 27);
        drawCurve(g,70, 27, 62, 14, 48, 22, 33, 20);
    }


    //Algorytm
    private void drawCurve(Graphics g,int xaa , int yaa , int xa , int  ya , int  xb , int yb  , int xz , int yz ) {
        int wynikx, wyniky;
        int tabx[] = new int[]{xaa, xa, xb, xz};
        int taby[] = new int[]{yaa, ya, yb, yz};
        for (double t = 0.0; t <= 1.0; t += 0.005) {
            {

                wynikx = (int) (startx + xt);
                wyniky = (int) (starty + yt);
                xt = Math.pow(1 - t, 3) * tabx[0] + 3 * t * Math.pow(1 - t, 2) * tabx[1] + 3 * Math.pow(t, 2) * (1 - t) * tabx[2] + Math.pow(t, 3) * tabx[3];
                yt = Math.pow(1 - t, 3) * taby[0] + 3 * t * Math.pow(1 - t, 2) * taby[1] + 3 * Math.pow(t, 2) * (1 - t) * taby[2] + Math.pow(t, 3) * taby[3];
                g.fillOval(wynikx, wyniky, 8, 8);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button_back_frame){
            this.dispose();
            new My_frame();
        }
    }
}

