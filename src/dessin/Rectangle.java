package dessin;

import java.awt.*;

public class Rectangle extends ObjetGraphique{
    private java.awt.Rectangle rectangle;

    public Rectangle(int x, int y, int largeur, int hauteur){
        rectangle=new java.awt.Rectangle(x, y, largeur, hauteur);
    }
    public Rectangle(Point p, int largeur, int hauteur){
        Dimension dimension=new Dimension(largeur, hauteur);
        rectangle=new java.awt.Rectangle(p, dimension);
    }
    public Rectangle(Point p, int largeur,int hauteur,Color c){
        super(c);
        Dimension dimension=new Dimension(largeur, hauteur);
        rectangle=new java.awt.Rectangle(p, dimension);
    }
    public Rectangle(){
        rectangle=new java.awt.Rectangle();
    }
    public void dessineToi(Graphics graphics){
        graphics.drawRect((int)rectangle.getX(), (int)rectangle.getY(), (int)rectangle.getWidth(), (int)rectangle.getHeight());
    }
    public boolean  contient(int a, int b){
        return rectangle.contains(a, b);
    }
}
