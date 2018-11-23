package aplicacion;
import java.util.*;
import java.io.*;
import java.awt.*;
/**
 * Write a description of class Extraterrestre here.
 *
 * @author (Julian David Gutierrez & Andres Ricardo Martinez)
 * @version (1.0)
 */
public abstract class Extraterrestre extends Elemento {
    
    public String mov;
    /**
     * Constructor for objects of class Extraterrestre
     */
    public Extraterrestre(int x , int y , SpaceInvaders sc) {  
        super(x , y , sc);
        mov = "derecha";
    }

    /**
     * 
     */
    public void mover()
    {
        if ((x + 20 == sp.getWidth() && mov.equals("derecha")) || ((x == 0) && mov.equals("izquierda"))){
            sp.bajarInvasores();
        }
        else{
            if (mov.equals("derecha")){
                super.x++;
            }
            else{
                super.x = super.x - 1;
            }
        }
    }
    
    /**
     *
     */
    public void bajar()
    {
       super.y+= 20;
    }
    
    public void desaparecer(){
        visible = false;
        sp.setScore(score);
    }
    
    public boolean isVivo(){
        return visible;
    }
    
    public void setMov(){
        if (mov.equals("derecha")){
            mov = "izquierda";
        }
        else{
            mov = "derecha";
        }
    }
    
    public abstract void disparar();
    public abstract void definirVidas();
}
