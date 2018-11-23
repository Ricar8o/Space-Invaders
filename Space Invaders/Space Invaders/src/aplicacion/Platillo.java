package aplicacion;
/**
 * Write a description of class platillo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platillo extends Nave
{
    /**
     * Constructor for objects of class platillo
     */
    public Platillo(int x, int y , SpaceInvaders sp)
    {
        super(x , y , sp);
        super.vidas=1;
    }

	@Override
	public void definirVidas() {
		// TODO Auto-generated method stub
		
	}
}
