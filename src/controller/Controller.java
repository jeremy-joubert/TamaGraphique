package controller;

import graphique.FenetreTamagoshi;
import graphique.FenetreConsole;
import tamagoshi.tamagoshis.GrosJoueur;
import tamagoshi.tamagoshis.GrosMangeur;
import tamagoshi.tamagoshis.Lunatique;
import tamagoshi.tamagoshis.Tamagoshi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Controller {

    private ArrayList<Tamagoshi> listeTotale;
    private FenetreConsole tamaGame;
    private ArrayList<FenetreTamagoshi> fenetreTamagoshis;
    private boolean partieTermine;

    public void lancementParti(){
        listeTotale = new ArrayList<>();
        partieTermine=false;
        JFrame.setDefaultLookAndFeelDecorated(true);
        int difficulter = saisirDifficulter();
        initialisation(difficulter);
        tamaGame=new FenetreConsole();
        tamaGame.setSize(600, 200);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension window = tamaGame.getSize();
        tamaGame.setLocationRelativeTo((Component)null);
        tamaGame.setTitle("FenetreConsole");
        tamaGame.setVisible(true);
        fenetreTamagoshis =new ArrayList<>();
        creationDesFenetresTamagoshi(difficulter);
        play();
    }

    private int saisirDifficulter(){
        int difficulter = 0;
        while (difficulter <= 2 || difficulter > 8) {
            try {
                difficulter = Integer.parseInt(JOptionPane.showInputDialog("Entrez le nombre de tamagoshis (Min : 3 et Max : 8) :", "3"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrez un nombre entre 3 et 8", "Erreur de saisie", 0);
            }
        }
        return difficulter;
    }

    private void initialisation(int nombreTamagoshi){
        for(int i=0;i<nombreTamagoshi;i++){
            String[] listNom={"Luffy", "Zorro", "Usop", "Nami", "Robin", "Chopper", "Brook", "Franky", "Jinbe"};
            if(Math.random()<.33){
                listeTotale.add(new GrosJoueur(listNom[i]));
            }else if(Math.random()<.5){
                listeTotale.add(new GrosMangeur(listNom[i]));
            }else{
                listeTotale.add(new Lunatique(listNom[i]));
            }
        }
    }

    private void creationDesFenetresTamagoshi(int nbFenetre) {
        for (int i = 0, x=0, y=0; i < nbFenetre; i++, x++) {
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            FenetreTamagoshi fenetreTamagoshi = new FenetreTamagoshi(listeTotale.get(i));
            fenetreTamagoshis.add(fenetreTamagoshi);
            if (x * (fenetreTamagoshi.getSize()).width + (fenetreTamagoshi.getSize()).width > screen.width) {
                x = 0;
                y += (fenetreTamagoshi.getSize()).height + 30;
            }
            fenetreTamagoshi.setLocation(x * ((fenetreTamagoshi.getSize()).width + 5), y);
            fenetreTamagoshi.setVisible(true);
        }
    }

    private void play(){
        int cycle=1;
        while (!partieTermine() && !partieTermine){
            tamaGame.afficherMessage("====Cycle n°"+cycle+"====");
            for(FenetreTamagoshi fenetreTamagoshi : fenetreTamagoshis){
                if(fenetreTamagoshi.getTamagoshi().isAlive()){
                    String message =fenetreTamagoshi.getTamagoshi().parle();
                    fenetreTamagoshi.afficherMessage(message);
                }
            }
            nourrir();
            faireJouer();
            faireGrandirLesTamagoshiEtConsommerLeurEnergie();
            changerEtatBoutonJouer(true);
            changerEtatBoutonNourir(true);
            cycle++;
        }
        tamaGame.afficherMessage("====Fin de partie!====");
        tamaGame.resultat(listeTotale);
    }

    private void nourrir(){
        tamaGame.afficherMessage("Nourrir quel tamagoshi?");
        attendreLeNourrisage();
    }
    private boolean attendreLeNourrisage(){
        boolean estDisponible=true;
        while (estDisponible){
            for (FenetreTamagoshi fenetreTamagoshi : fenetreTamagoshis){
                if(!fenetreTamagoshi.getBtNourrir()&&fenetreTamagoshi.getTamagoshi().isAlive()){
                    estDisponible=false;
                    changerEtatBoutonNourir(false);
                }
            }
        }
        return true;
    }

    private void faireJouer(){
        tamaGame.afficherMessage("Jouer avec quel tamagoshi?");
        attendreDeJouer();
    }

    private boolean attendreDeJouer(){
        boolean estDisponible=true;
        while (estDisponible){
            for (FenetreTamagoshi fenetreTamagoshi : fenetreTamagoshis){
                if(!fenetreTamagoshi.getBtJouer()&&fenetreTamagoshi.getTamagoshi().isAlive()){
                    estDisponible=false;
                    changerEtatBoutonJouer(false);
                }
            }
        }
        return true;
    }

    private void faireGrandirLesTamagoshiEtConsommerLeurEnergie(){
        for (FenetreTamagoshi fenetreTamagoshi : fenetreTamagoshis){
            Tamagoshi tamagoshi = fenetreTamagoshi.getTamagoshi();
            if(tamagoshi.isAlive()) {
                fenetreTamagoshi.afficherMessage(tamagoshi.consommeEnergie());
                fenetreTamagoshi.afficherMessage(tamagoshi.consommeFun());
                if(tamagoshi.vieillit()){
                    partieTermine=true;
                }

            }
        }
    }

    private boolean partieTermine(){
        boolean estTermine=true;
        for (FenetreTamagoshi fenetreTamagoshi : fenetreTamagoshis){
            if(fenetreTamagoshi.getTamagoshi().isAlive()){
                estTermine=false;
            }
        }
        return estTermine;
    }

    private void changerEtatBoutonNourir(boolean etat){
        for(FenetreTamagoshi fenetreTamagoshi : fenetreTamagoshis){
            fenetreTamagoshi.setBtNourrir(etat);
        }
    }

    private void changerEtatBoutonJouer(boolean etat){
        for(FenetreTamagoshi fenetreTamagoshi : fenetreTamagoshis){
            fenetreTamagoshi.setBtJouer(etat);
        }
    }

    /*private void afficherMessage(String message){
        for(TamgoshiController tamgoshiController : fenetreTamagoshis){
            tamgoshiController.afficherMessage(message);
        }
    }*/

    public static void main(String[] args) {
        Controller controller= new Controller();
        controller.lancementParti();
    }
}
