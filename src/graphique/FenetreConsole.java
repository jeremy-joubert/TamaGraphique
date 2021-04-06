package graphique;

import java.util.ArrayList;
import java.util.List;

import tamagoshi.tamagoshis.GrosJoueur;
import tamagoshi.tamagoshis.GrosMangeur;
import tamagoshi.tamagoshis.Lunatique;
import tamagoshi.tamagoshis.Tamagoshi;

import javax.swing.*;

public class FenetreConsole extends JFrame {

    private JTextArea console;

    /**constructeur d'une instance du jeu*/
    public FenetreConsole() {
        this.console=new JTextArea();
        add(new JScrollPane(this.console));
    }

    private double score(List<Tamagoshi> listeTotale){
        int score=0;
        for(Tamagoshi t : listeTotale)
            score += t.getAge();
        return score*100/(Tamagoshi.getLifeTime()*listeTotale.size());
    }

    public void resultat(List<Tamagoshi> listeTotale){
        afficherMessage("===========bilan==============");
        for(Tamagoshi t : listeTotale){
            String classe = t.getClass().getSimpleName();
            afficherMessage(t.getName()+" qui était un "+classe+" "+(t.getAge()==Tamagoshi.getLifeTime()?" a survécu et vous remercie :)":" n'est pas arrivé au bout et ne vous félicite pas :("));
        }
        afficherMessage("\nniveau de difficulté : "+listeTotale.size()+", score obtenu :"+score(listeTotale)+"%");
    }



    public void afficherMessage(String message) {
        this.console.append(message+"\n");
        this.console.setCaretPosition(this.console.getDocument().getLength());
    }


}