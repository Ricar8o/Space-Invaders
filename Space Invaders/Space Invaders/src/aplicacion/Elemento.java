package aplicacion;
import java.awt.Rectangle;
import java.util.*;

public abstract class Elemento extends Rectangle{
	protected boolean vida;
    protected SpaceInvaders sp;
    protected boolean visible;
    protected int score;
    protected int vidas;
    protected boolean amistoso;
    
    /**
     * Constructor for objects of class Elemento.
     */
    public Elemento(int x , int y , SpaceInvaders sp){
       super(x , y , 20 , 20);
       visible = true;
       this.sp = sp;
    }
    
    public abstract void definirVidas();
}
