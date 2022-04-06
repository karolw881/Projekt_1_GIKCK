

import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import javax.swing.*;

public class Menu_snake extends JFrame implements ActionListener {
    JButton b1;
    JButton b3;
    JFrame ex ;
    public Menu_snake() {

        initUI();
    }
    private void initUI() {

        Creat_button();
        Set_focusable();
        Add_action_listener();
        Add_Button_to_frame();
        set_button_color();

        this.setTitle("Menu Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800,800);
        this.setVisible(true);
        this.setLayout(new GridLayout(1,2));

    }
    public void Creat_button(){
        b1 = new JButton("START GAME ");
        b3 = new JButton("BACK");
    }
    public void Set_focusable(){
        b1.setFocusable(false);
        b3.setFocusable(false);
    }
    public void Add_action_listener(){
        b1.addActionListener(this);
        b3.addActionListener(this);

    }
    public void Add_Button_to_frame(){
        this.add(b1);
        this.add(b3);

    }
    public void set_button_color(){
        b1.setBackground(Color.green);
        b3.setBackground(Color.cyan);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            this.dispose();
            EventQueue.invokeLater(() -> {
                ex = new Snake();
                ex.setVisible(true);
            });
        }
        if(e.getSource() == b3){
            this.dispose();
            My_frame f3 = new My_frame();
        }
    }
}

