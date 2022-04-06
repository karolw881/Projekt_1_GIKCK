import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

    private final int B_WIDTH = 800;
    private final int B_HEIGHT = 800;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;
    private final int DELAY = 140;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;

    private int cytrynka_x;
    private int cytrynka_y;



    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;
    private Image lemon ;

    public JButton bb ;
    public JLabel label ;
   // int licznik_p = 0 ;

    ArrayList<Rectangle> rec  ;

    Rectangle snake_head ;
    Rectangle a2 ;

    int width = 100 ;
    int height = 30 ;



    public Board() {
        // Dodanie przycisku Back i labelka informujacego o ilosci punktow
        bb = new JButton("Back");
        bb.setFocusable(false);
        bb.addActionListener(this);
        bb.setBounds(0,0,100,50);
        rec = new ArrayList<Rectangle>();

      //  label = new JLabel(String.valueOf(licznik_p));
        //label.setForeground(Color.green);
      //  label.setBounds(B_HEIGHT - 10,B_WIDTH-10 , 40 , 40) ;

       // this.add(label);


        initBoard();
    }

    // dodanie kolumn do arraylist
    public void addColumn(boolean start){

        if(start)
        {
            rec.add(new Rectangle(200 , 100 , width,height));
            rec.add(new Rectangle(100 , 200 , width,height));
            rec.add(new Rectangle(400 , 600 , width,height));
            rec.add(new Rectangle(500 , 100 , width,height));
            rec.add(new Rectangle(200 , 300 , width,height));
            rec.add(new Rectangle(700 , 400 , width,height));
            rec.add(new Rectangle(600 , 550 , width,height));
        }
    }

    // stworzenie drugiego jablka


    private void initBoard() {
        addColumn(true);
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    private void loadImages() {

        ImageIcon iid = new ImageIcon("dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("head.png");
        head = iih.getImage();

        ImageIcon i2 = new ImageIcon("cytryna1.jpg");
        lemon =  i2.getImage();
    }

    private void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        locateApple();
        locateLemon();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        if (inGame) {
            addColumn(true);

            // wyswietelnie prostokatow na planszy
            g.drawImage(apple, apple_x, apple_y, this);
            g.drawImage(lemon,cytrynka_x,cytrynka_y,this);
            g.setColor(Color.red.darker());
            g.fillRect(rec.get(0).x  , rec.get(0).y , rec.get(0).width  , rec.get(0).height );
            g.setColor(Color.yellow);
            g.fillRect(rec.get(1).x  , rec.get(1).y , rec.get(1).width  , rec.get(1).height );
            g.setColor(Color.magenta);
            g.fillRect(rec.get(2).x  , rec.get(2).y , rec.get(2).width  , rec.get(2).height );
            g.setColor(Color.BLUE);
            g.fillRect(rec.get(3).x  , rec.get(3).y , rec.get(3).width  , rec.get(3).height );
            g.setColor(Color.red.darker());
            g.fillRect(rec.get(4).x  , rec.get(4).y , rec.get(4).width  , rec.get(4).height );
            g.setColor(Color.yellow);
            g.fillRect(rec.get(5).x  , rec.get(5).y , rec.get(5).width  , rec.get(5).height );
            g.setColor(Color.magenta);
            g.fillRect(rec.get(6).x  , rec.get(6).y , rec.get(6).width  , rec.get(6).height );
            g.setColor(Color.BLUE);
            g.fillRect(rec.get(7).x  , rec.get(7).y , rec.get(7).width  , rec.get(7).height );


            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }
    }

    private void gameOver(Graphics g) {


        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        this.add(bb);

    }

    private void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots++;
            locateApple();
        }
    }
    private void checkLemon() {

        if ((x[0] == cytrynka_x) && (y[0] == cytrynka_y)) {

            dots++;
            locateLemon();
        }
    }

    private void move() {

        for (int z = dots; z > 0; z--) {
            //snake_head = new Rectangle(x[z-1] , y[z-1] , 1 , 1);
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }

    // TUTAJ kombinowane dodawania  blokow kolizyjnych

    private void checkCollision() {

        for (int z = dots; z > 0; z--) {
            for(int p = 0 ; p < rec.size() ; p++) {
                for (int k = 0; k < rec.get(0).width; k++) {
                    for (int kk = 0; kk < rec.get(0).height; kk++)
                        if ((rec.get(p).x + k == x[0] && rec.get(p).y + kk == y[0])
                        ) {
                            inGame = false;
                        }
                }
            }

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }

    }

    //Zmiana lokacji jablka zeby nie wypadalo na prostokacie
    private void locateApple() {
        for(int p = 0 ; p < rec.size() ; p++) {
            for (int k = 0; k < rec.get(0).width; k++) {
                for (int kk = 0; kk < rec.get(0).height; kk++)
                    if ((rec.get(p).x + k == x[0] && rec.get(p).y + kk == y[0])
                    ) {
                        locateApple();
                    }else{
                        int r = (int) (Math.random() * RAND_POS);
                        apple_x = ((r * DOT_SIZE));
                        r = (int) (Math.random() * RAND_POS);
                        apple_y = ((r * DOT_SIZE));
                       // licznik_p++;


                    }
            }
            }

    }

    //wygenerowanie cytrynki na grze
    private void locateLemon() {
        for(int p = 0 ; p < rec.size() ; p++) {
            for (int k = 0; k < rec.get(0).width; k++) {
                for (int kk = 0; kk < rec.get(0).height; kk++)
                    if ((rec.get(p).x + k == x[0] && rec.get(p).y + kk == y[0])
                    ) {
                        locateLemon();
                    }else{
                        int r = (int) (Math.random() * RAND_POS);
                        cytrynka_x = ((r * DOT_SIZE));
                        r = (int) (Math.random() * RAND_POS);
                        cytrynka_y = ((r * DOT_SIZE));


                    }
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkApple();
            checkLemon();
            checkCollision();
            move();
        }

        if(e.getSource() == bb){
            Menu_snake m1 = new Menu_snake();
        }


        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
}