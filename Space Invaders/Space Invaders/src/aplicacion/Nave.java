package aplicacion;
import java.awt.*;
/**
 * Write a description of class Nave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Nave extends Elemento{
    /**
     * Constructor for objects of class Nave
     */
    public Nave(int x , int y , SpaceInvaders sp)
    {
       super(x , y , sp);
    }

    /**
     * metodo para mover hacia la derecha la nave.
     */
    public void moverDerecha()
    {
        if ((x < (sp.getWidth()-20))){
            super.x++;
        }
    }
    
    /**
     *
     */
    public void moverIzquierda()
    {
        if (x>=0){
            super.x = super.x - 1;
        }
    }
    
    public void desaparecer(){
        visible = false;
        sp.setScore(score);
    }
    
    public boolean isVivo(){
        return visible;
    }
   
}
