package dessin;

import java.awt.*;

public abstract class ObjetGraphique {
    private  java.awt.Color couleur;
    private boolean visible;

    public ObjetGraphique(){
        this.couleur=new Color(0,0,0);
    }
    public ObjetGraphique(Color color){
        this.couleur=color;
    }
    public Color getCouleur() {
        return couleur;
    }
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    public abstract void dessineToi(Graphics graphics);
    public abstract boolean contient(int a, int b);
    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public void setColor(Color c){ couleur=c;}

    public Color getColor() { return(couleur);}
}
