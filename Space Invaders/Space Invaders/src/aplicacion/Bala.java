package aplicacion;
import java.util.*;
import java.io.*;
import java.awt.*;
/**
 * Write a description of class Bala here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Bala extends Rectangle{
    protected SpaceInvaders sc;
    private boolean visible;
    protected Nave na;
    /**
     * Constructor for objects of class Bala
     */
    public Bala(int x, int y , SpaceInvaders sc) 
    {
        super(x , y , 5 , 7);
        this.sc = sc;
        visible = true;
    }
    
    public void desaparecer(){
        visible = false;
    }
    
    public boolean isVivo(){
        return visible;
    }
  
    public abstract void mover();
}
