import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Bezier3d extends JFrame implements ActionListener{
    double x , y , z ;
    Point[][] punkt ;
    int plaszczyzny;

    PrintWriter zapisany_plik;
    Scanner in , inkubek , inlyzka;

    ArrayList<Double> lista_pkt_bezier_x ;
    ArrayList<Double> lista_pkt_bezier_y ;
    ArrayList<Double> lista_pkt_bezier_z ;

    Image zdjecie ;
    panelbezier3d panel;

    Button Jbutton ;


    Bezier3d() {
        //Inicjalizacja
        lista_pkt_bezier_x = new ArrayList<Double>();
        lista_pkt_bezier_y= new ArrayList<Double>();
        lista_pkt_bezier_z = new ArrayList<Double>();

        x = 0.0;
        y = 0.0;
        z = 0.0;



        punkt = new Point[4][4];
        plaszczyzny = 0;
        panel = new panelbezier3d();
        Jbutton = new Button("Back to Menu");
        zdjecie =  new ImageIcon("bezier3d.png").getImage();
        add_button();

        this.add(Jbutton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1200,1000);
        this.add(panel);
        this.pack();
        this.setVisible(true);

        try {
            //zapisany_plik = new PrintWriter("plik_po_wzorze_czajnik.txt");
            //zapisany_plik = new PrintWriter("plik_po_wzorze_lyzka.txt");
            zapisany_plik = new PrintWriter("plik_po_wzorze_kubek.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        czytaj_z_pliku();
    }

    public void add_button(){
        Jbutton.setBackground(Color.cyan);
        Jbutton.setSize(new Dimension(100,100));
        Jbutton.setFocusable(false);
        Jbutton.setBounds(0,0,100,100);
        Jbutton.addActionListener(this);
    }

    public void czytaj_z_pliku() {
        // File file = new File("czajnik.txt");
        //File file = new File("lyzka.txt");
        File file = new File("kubek.txt");
        try {
            in = new Scanner(file);
            // inlyzka = new Scanner(file);
            //in = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        plaszczyzny = in.nextInt();
        String elo = "x ,y, z";
        zapisz_linijke_do_pliku(elo);
        int L = plaszczyzny;

        //ALGORYTM
        for (int p = 0; p < L; p++) {
            for (int q = 0; q < 4; q++) {
                for (int qq = 0; qq < 4; qq++) {
                    double tempx = Double.parseDouble(in.next());
                    double tempy = Double.parseDouble(in.next());
                    double tempz = Double.parseDouble(in.next());
                    punkt[q][qq] = new Point(tempx, tempy, tempz);
                }
            }

        for (double v = 0.0; v <= 1.0; v += 0.01) {
            for (double w = 0.0; w <= 1.0; w += 0.01) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        x += punkt[i][j].x * licz_bersteina(3, i, w) * licz_bersteina(3, j, v);
                        y += punkt[i][j].y * licz_bersteina(3, i, w) * licz_bersteina(3, j, v);
                        z += punkt[i][j].z * licz_bersteina(3, i, w) * licz_bersteina(3, j, v);
                    }
                }

                String ss = x + "," + y + "," + z;
                zapisz_linijke_do_pliku(ss);
                x = 0.0;
                y = 0.0;
                z = 0.0;
            }
        }
    }
            in.close();
        }

    //funkcja zapisuja linijke do pliku
    public void zapisz_linijke_do_pliku(String lajn) {
        zapisany_plik.println(lajn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Jbutton){
            this.dispose();
            new My_frame();
        }
    }

    public static long licz_newton(int n, int k) {
        long Wynik = 1;
        int i;
        for (i = 1; i <= k; i++) {
            Wynik = Wynik * (n - i + 1) / i;
        }
        return Wynik;
    }

    public double licz_bersteina(int x, int y, double kk) {
        return licz_newton(x, y) * Math.pow(kk, y) * Math.pow(1 - kk, x - y);
    }
}
