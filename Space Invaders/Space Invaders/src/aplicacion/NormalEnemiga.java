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
public class NormalEnemiga extends Bala
{
    Extraterrestre ex;
    /**
     * Constructor for objects of class Especial
     */
    public NormalEnemiga(int x , int y, SpaceInvaders sc , Extraterrestre ex)
    {
       super (x , y , sc);
       this.ex = ex;
    }
    
    public void mover ()
    {
        if (y > sc.getLenght()){
            setLocation(x , y +1);
            ArrayList<Elemento> re = sc.getAliadas();
            for (int i = 0 ; i < re.size() ; i++){
            	Elemento r = re.get(i);
                if (super.intersects(r)){
                    if (r instanceof Extraterrestre){
                        Extraterrestre e = (Extraterrestre) r;
                        e.desaparecer();
                        super.desaparecer();
                    }
                }
            }
        }
        else{
            desaparecer();
        }
    }
}