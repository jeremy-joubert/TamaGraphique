package tamagoshi.tamagoshis;

public class GrosMangeur extends Tamagoshi {

    public GrosMangeur(String name) {
        super(name);
    }

    public String consommeEnergie(){
        energy--;
        return super.consommeEnergie();
    }
}
