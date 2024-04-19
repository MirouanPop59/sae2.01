
import java.util.*;

/**
 * 
 */
public class Monde {

    private Secteur leMonde[];

    private int nbMineOr;
    private int nbMineNickel;
    private int nbRobotNickel;
    private int nbRobotor;

    public  Monde(){
        this.leMonde = new Secteur [100];
        this.nbRobotNickel=genererInt(1,5);
        this.nbMineNickel=genererInt(1,2);
        this.nbMineOr=genererInt(1,2);
        this.nbRobotor=genererInt(1,5);
    }

    public int genererInt(int borneInf,int borneSup){
        Random random=new Random();
        int nb;
        nb=borneInf+random.nextInt(borneSup-borneInf);
        return nb;
    }

    public void Affichage() {
    }

    public void CreerMondeVierge() {
    }

    public void CreerMondeFini() {
    }

}