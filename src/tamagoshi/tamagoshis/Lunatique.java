package tamagoshi.tamagoshis;

public class Lunatique extends Tamagoshi {

    public Lunatique(String name) {
        super(name);
    }

    @Override
    public String consommeEnergie() {
        if(generateur.nextBoolean())
            energy--;
        return super.consommeEnergie();
    }

    @Override
    public String consommeFun() {
        if(generateur.nextBoolean())
            fun--;
        return super.consommeFun();
    }

}
