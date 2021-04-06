package tamagoshi.tamagoshis;

import java.util.Random;

public class Tamagoshi {
    private String name;
    protected Random generateur;
    private int age,maxEnergy,maxFun;
    protected int fun;
    protected int energy;
    private static int lifeTime=10;

    public Tamagoshi(String name) {
        this.name = name;
        generateur=new Random();
        age=0;
        maxEnergy=generateur.nextInt(5)+5;
        maxFun=generateur.nextInt(5)+5;
        energy=generateur.nextInt(5)+3;
        fun=generateur.nextInt(5)+3;
    }

    public String parle() //Exo 16
    {
        String s="";
        if (energy < 5)
            s+="je suis affamé";
        if(fun<5){
            if(! s.isEmpty())
                s+=" et ";
            s+="je m'ennuie à mourrir";
        }
        if(s.isEmpty()){
            return parler("Tout va bien !");
        }
        else{
            return parler(s+" !");
        }
    }

    private String parler(String phrase){
        System.out.println("\n\t"+name+" : \""+phrase+"\"");
        return "\n\t"+name+" : \""+phrase+"\"";
    }

    public String mange(){	 //Exo 4
        if (energy < maxEnergy)
        {
            energy += generateur.nextInt(3)+1;
            parler("Merci !");
            return "Merci !";
        }
        else
        {
            parler("je n'ai pas faim !!");
            return "je n'ai pas faim !!";
        }
    }

    public boolean vieillit(){ 	//Exo 5
        age++;
        return age==getLifeTime();
    }

    public String consommeEnergie(){	//Exo 6
        energy--;
        if(energy<=0){
            parler("je suis KO: Arrrggh !");
            return "je suis KO: Arrrggh !";
        }
        return "";
    }

    public String consommeFun(){	//Exo 6
        fun--;
        if(fun<=0){
            parler("snif : je fais une dépression!");
            return "snif : je fais une dépression!";
        }
        return "";
    }
    /**
     * @return Returns the age.
     */
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    /**
     * @return Returns the lifeTime.
     */
    public static int getLifeTime() {
        return lifeTime;
    }

    public String joue(){
        if (fun < maxFun){
            fun += generateur.nextInt(3)+1;
            parler("On se marre !");
            return "On se marre !";
        }
        else{
            parler("laisse-moi tranquille!!");
            return "laisse-moi tranquille!!";
        }
    }

    public String toString(){
        return name+" : energy="+energy+", fun="+fun;
    }

    public boolean isAlive() {
        return fun>0 && energy>0;
    }


}
