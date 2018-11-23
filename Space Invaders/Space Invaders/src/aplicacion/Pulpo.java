package aplicacion;
/**
 * Write a description of class Pulpo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pulpo extends Extraterrestre
{
    /**
     * Constructor for objects of class Pulpo
     */
    public Pulpo (int x , int y, SpaceInvaders sc){  
        super(x , y, sc);
        super.vida = true;   
        super.vidas=1;
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
