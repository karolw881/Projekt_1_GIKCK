import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class panelbezier3d extends JPanel{
    Image i ;
    panelbezier3d(){
        String inputImagePath = "bezier3d.png";
        String outputImagePath1 = "bezier3dd.png";
        //String outputImagePath2 = "D:/Photo/Puppy_Smaller.jpg";
        //  String outputImagePath3 = "D:/Photo/Puppy_Bigger.jpg";

        try {
            // resize to a fixed width (not proportional)
            int scaledWidth = 1200;
            int scaledHeight =800;
            //ImageResizer.resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);

            // resize smaller by 50%
            double percent = 0.5;
            ImageResizer.resize(inputImagePath, outputImagePath1, percent);

            // resize bigger by 50%
            percent = 1.5;
            //ImageResizer.resize(inputImagePath, outputImagePath3, percent);

        } catch (IOException ex) {
            System.out.println("Error resizing the image.");
            ex.printStackTrace();
        }

        i = new ImageIcon("bezier3dd.png").getImage();
        this.setPreferredSize(new Dimension(1000,1000));


    }


    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(i, 0 , 0, null);

    }






}
