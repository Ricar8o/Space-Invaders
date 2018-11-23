package aplicacion;
import java.util.*;
import java.io.*;
import java.awt.*;
/**
 * Write a description of class Especial here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Normal extends Bala
{
    private Nave na;
    /**
     * Constructor for objects of class Especial
     */
    public Normal(int x , int y, SpaceInvaders sc , Nave na)
    {
       super (x , y , sc);
       this.na = na;
    }
    
    public void mover ()
    {
        if (y > 10){
            super.y = super.y - 1;
            ArrayList<Elemento> re = sc.getEnemigas();
            for (int i = 0 ; i < re.size() ; i++){
                Elemento r = re.get(i);
                if (super.intersects(r)){
                    if (r instanceof Extraterrestre){
                        Extraterrestre e = (Extraterrestre) r;
                        if (e.isVivo()){
                            e.desaparecer();
                            super.desaparecer();
                        }
                    }
                }
            }
        }
        else{
            desaparecer();
        }
    }
}
