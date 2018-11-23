package aplicacion; 
import java.util.*;
import java.io.*;
import java.awt.*;
/**
 * Write a description of class SpaceInvaders here.
 *
 * @author (Julian David Gutierrez & Andres Ricardo Martinez)
 * @version (1.0)
 */
public class SpaceInvaders{
    private ArrayList<Rectangle> ob;
    private ArrayList<Elemento> enemigas;
    private ArrayList<Elemento> aliadas;
    private ArrayList<Rectangle> balas;
    private int width;
    private int height;
    private int score;
    private Defensor j1;
	private ArrayList<Elemento> oleada;
    /**
     * Constructor for objects of class SpaceInvaders
     */
    public SpaceInvaders(int width , int height){
        ob = new ArrayList<Rectangle>();
        enemigas = new ArrayList<Elemento>();
        aliadas = new ArrayList<Elemento>();
        balas = new ArrayList<Rectangle>();
		oleada=new ArrayList<Elemento>();
        this.width = width;
        this.height = height;
        score = 0;
        j1 = new Defensor (width/2 - 20 , height - 20 , this);
        aliadas.add(j1);
        ob.add(j1);
		crearOleada();
    }

    /**
     */
    public void crearInvasorCalamar(int x , int y)
    {
        Calamar c = new Calamar(x , y , this);
        enemigas.add(c);
        ob.add(c);
    }
    
     /**
     */
    public void crearInvasorCangrejo(int x , int y)
    {
        Cangrejo ca = new Cangrejo(x , y , this);
        enemigas.add(ca);
        ob.add(ca);
    }
    
     /**
     */
    public void crearInvasorPulpo(int x , int y)
    {
        Pulpo p = new Pulpo(x , y , this);
        enemigas.add(p);
        ob.add(p);
    }
    
     /**
     */
    public void crearInvasorPlatillo(int x , int y)
    {
        Platillo pl = new Platillo(x , y , this);
        enemigas.add(pl);
        ob.add(pl);
    }
    
    /**
     * 
     */
    public void bajarInvasores()
    {
        for (Rectangle r : enemigas){
            if (r instanceof Extraterrestre){
                Extraterrestre e = (Extraterrestre) r;
                e.bajar();
                e.setMov();
            }
        }
    }
	
	/**
     * 
     */
    public void crearOleada(){
        if (oleada.size()==0){
			int y=70;
			for(int i =0; i<5;i++){
				int x=100;
				for(int j =0;j<10;j++){
					int dat= (int) (Math.random()* 2 );
					if (dat==0){
						crearInvasorCalamar(x , y);
					}
					else if (dat==1){
						crearInvasorCangrejo(x , y);
					}
					else{
						crearInvasorPulpo(x , y);
					}
					x+=30;
				}
				y+=30;
			}
		}
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getLenght(){
        return height;
    }
    
    public ArrayList<Elemento> getEnemigas(){
        return enemigas;
    }
    
    public ArrayList<Elemento> getAliadas(){
        return aliadas;
    }
    
    public ArrayList<Rectangle> getOb(){
        return ob;
    }
    
    public void setScore(int v){
        score+= v;
    }
    
    public void addBala(Rectangle r){
        balas.add(r);
        ob.add(r);
    }
    
    public void moverDerechaJ1(){
        j1.moverDerecha();
    }
    
    public void moverIzquierdaJ1(){
        j1.moverIzquierda();
    }
    
    public void dispararJ1(){
        j1.disparar();
    }
    
    public void actualizar(){
        for (int i = 0; i< ob.size(); i++){
            Rectangle re = ob.get(i);
            if (re instanceof Extraterrestre){
                Extraterrestre e = (Extraterrestre) re;
                if (e.isVivo()){
                    e.mover();
                }
            }
            if (re instanceof Bala){
                Bala b = (Bala) re;
                if (b.isVivo()){
                    b.mover();
                }
            }
        }
    }
}
