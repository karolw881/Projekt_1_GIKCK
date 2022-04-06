import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Start aplikacji
        EventQueue.invokeLater(() -> {
            Frame f1 = new My_frame();
        });

        // Metoda zmieniajaca rozmiar obrazka , z internetu , wykorzystana do zmiejszenia cytryny w snakeu , udokumentowane w klasie ImageResizer
        String inputImagePath = "cytryna.jpg";
        String outputImagePath1 = "cytryna1.jpg";
        try {
            int scaledWidth = 20;
            int scaledHeight = 20;
            ImageResizer.resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);
        } catch (IOException ex) {
            System.out.println("Error resizing the image.");
            ex.printStackTrace();
        }
    }
}


