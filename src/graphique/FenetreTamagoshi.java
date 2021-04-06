package graphique;

import dessin.TamaDessin;
import tamagoshi.tamagoshis.Tamagoshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreTamagoshi extends JFrame implements ActionListener {

    private Tamagoshi tamagoshi;

    private JButton btNourrir;
    private JButton btJouer;
    private boolean etatbtNourrir;
    private  boolean etatbtJouer;
    private TamaDessin tamaDessin;

    public FenetreTamagoshi(Tamagoshi tamagoshi){
        etatbtJouer=true;
        etatbtNourrir=true;
        this.tamagoshi =tamagoshi;
        setTitle(tamagoshi.getName());

        JPanel panelBouton=new JPanel();
        btNourrir = new JButton("Nourrir");
        btJouer = new JButton("Jouer");
        panelBouton.add(btNourrir);
        panelBouton.add(btJouer);

        tamaDessin = new TamaDessin();
        add(tamaDessin);
        add(panelBouton, BorderLayout.PAGE_END);


        setSize(300, 300);
        btNourrir.addActionListener(this);
        btJouer.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btNourrir){
            bouttonNourrirAction();
        }
        if(e.getSource()==btJouer){
            bouttonJouerAction();
        }
    }

    private void bouttonNourrirAction() {
        afficherMessage(tamagoshi.mange());
        setBtNourrir(false);
    }

    private void bouttonJouerAction(){
        afficherMessage(tamagoshi.joue());
        setBtJouer(false);
    }

    public void afficherMessage(String message){
        if (message!="") {
            tamaDessin.afficherMessage(message);
        }
    }

    public void setBtNourrir(boolean etatBouton){
        if(tamagoshi.isAlive()){
            this.btNourrir.setEnabled(etatBouton);
            this.etatbtNourrir=etatBouton;
        }else{
            this.btNourrir.setEnabled(false);
            this.etatbtNourrir=false;
        }
    }

    public void setBtJouer(boolean etatBouton){
        if(tamagoshi.isAlive()){
            this.btJouer.setEnabled(etatBouton);
            this.etatbtJouer=etatBouton;
        }else{
            this.btNourrir.setEnabled(false);
            this.etatbtJouer=false;
        }
    }

    public boolean getBtNourrir() {
        return etatbtNourrir;
    }

    public boolean getBtJouer() {
        return etatbtJouer;
    }

    public Tamagoshi getTamagoshi(){
        return tamagoshi;
    }

}
