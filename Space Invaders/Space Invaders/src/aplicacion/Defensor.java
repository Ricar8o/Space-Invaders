package aplicacion;
/**
 * Write a description of class Defensor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Defensor extends Nave{
    /**
     * Constructor for objects of class Defensor
     */
    public Defensor(int x, int y, SpaceInvaders sp)
    {
        super(x , y, sp);
        super.vidas = 3;
    }
    
    public void desaparecer(){
        if (vidas == 1){
            super.visible = false;
        }
        else{
            vidas+= -1;
        }
    }
    
    public void disparar(){
        Bala b = new Normal(x + 4 , y + 2 , super.sp ,  this);
        sp.addBala(b);
    }

	@Override
	public void definirVidas() {
		// TODO Auto-generated method stub
		
	}
}
