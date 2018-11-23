package aplicacion;
import java.lang.*;
/**
 * Write a description of class Pulpo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Calamar extends Extraterrestre
{
    /**
     * Constructor for objects of class Pulpo
     */
    public Calamar (int x , int y, SpaceInvaders sc){  
        super(x , y , sc);
        super.vida = true;   
        super.vidas=(int) (Math.random() * 3)+1;
    }
    
    public void disparar(){
        Bala b = new NormalEnemiga(x + 5 , y - 5 , super.sp ,  this);
        sp.addBala(b);
    }

	@Override
	public void definirVidas() {
		// TODO Auto-generated method stub
		
	}
}