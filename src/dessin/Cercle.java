package dessin;

import java.awt.*;

public class Cercle extends ObjetGraphique{
    private Point point;
    private int rayon;

    public Cercle(Point centre, int rayon){
        this.point=centre;
        this.rayon=rayon;
    }
    public Cercle(Point centre, int rayon, Color couleur){
        super(couleur);
        this.point=centre;
        this.rayon=rayon;
    }
    @Override
    public void dessineToi(Graphics graphics) {
        graphics.drawOval((int)point.getX(), (int)point.getY(), rayon, rayon);
    }

    @Override
    public boolean contient(int a, int b) {
        int R=rayon^2;
        if(((a-(int)point.getX())^2+(b-(int)point.getY())^2) <= R ){
            return true;
        }
        return false;
    }
}
