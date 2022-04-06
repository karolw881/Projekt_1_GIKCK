import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class My_frame extends JFrame  implements ActionListener   {
    // Stworzenie buttonow i icon
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;

    ImageIcon icon ;
    ImageIcon icon2;
    ImageIcon icon3 ;
    My_frame(){
        Creat_button();
        Set_focusable();
        Add_action_listener();
        Add_Button_to_frame();
        set_button_color();
        Creat_Icon_image();

        this.setTitle("PROJEKT");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1200,800);
        this.setVisible(true);
        this.setLayout(new GridLayout(5,1));

    }

    public void Creat_Icon_image(){
        icon = new ImageIcon("image_fractallo.jpg");
        icon2 = new ImageIcon("snake.jpg");
        icon3 = new ImageIcon("tetris.jpg");

        /*
        button1.setHorizontalTextPosition(JButton.RIGHT);
        button1.setVerticalTextPosition(JButton.TOP);
         */

        button1.setHorizontalTextPosition(JButton.CENTER);
        button1.setVerticalTextPosition(JButton.EAST);
        button1.setText("Click Me to show Fraktal");
        button1.setIcon(icon);
        button1.setFont(new Font("Serif", Font.BOLD ,25));
        button1.setIconTextGap(-120);
        button1.setForeground(Color.pink);


        button4.setIcon(icon2);
        button2.setIcon(icon3);
        button1.setIconTextGap(-120);
    }


    public void Creat_button(){
        button1 = new JButton();
        button2 = new JButton("Game Tetris (Strajker)");
        button3 = new JButton("Inicjaly");
        button4 = new JButton("Game Snake");
        button5 = new JButton("Bezier 3Ds");
    }

    public void Set_focusable(){
        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);
        button4.setFocusable(false);
        button5.setFocusable(false);

    }

    public void Add_action_listener(){
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
    }

    public void Add_Button_to_frame(){
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
    }

    public void set_button_color(){
        button1.setBackground(Color.BLUE);
        button2.setBackground(Color.white);
        button3.setBackground(Color.cyan);
        button4.setBackground(Color.RED);
        button5.setBackground(Color.yellow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button1){
            this.dispose();
            Fraktal x = new Fraktal();
        }

        if(e.getSource() == button2){
            this.dispose();
            JFrame ex = new Tetris();
            ex.setVisible(true);
        }
        if(e.getSource() == button3){
            this.dispose();
            Bezier b1 = new Bezier();
        }

        if(e.getSource() == button4){
            this.dispose();
           Menu_snake mmx = new Menu_snake();


        }
        if(e.getSource() == button5){
            this.dispose();
            new Bezier3d();

        }
    }
}
