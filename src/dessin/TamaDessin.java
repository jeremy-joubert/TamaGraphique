package dessin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TamaDessin extends JPanel {

    private List<ObjetGraphique> figures;
    private String message;

    public TamaDessin(){
        this.figures = new ArrayList<>();
        this.figures.add(new Cercle(new Point(100, 40), 20));
        this.figures.add(new Cercle(new Point(160, 40), 20));
        this.figures.add(new Rectangle(130, 70, 20, 20));
        this.figures.add(new Rectangle(100, 100, 80, 20));
        this.figures.add(new Rectangle(90, 30, 100, 100));
        this.message="";
    }

    public void afficherMessage(String message){
        this.message=message;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ObjetGraphique objetGraphique : figures){
            objetGraphique.dessineToi(g);
            g.drawString(this.message, 10, 20);
        }
    }
}
