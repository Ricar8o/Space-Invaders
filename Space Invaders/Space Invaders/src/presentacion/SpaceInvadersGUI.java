package presentacion;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import javax.swing.filechooser.*;
import java.io.*;
import javax.swing.border.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import aplicacion.*;
import java.awt.Rectangle;

public class SpaceInvadersGUI extends JFrame implements ActionListener{
    private JMenuBar mb;
    private JMenu menu1;
    private JFileChooser chooser;
    private JMenuItem mi1,mi2,mi3,mi4,mi5;
    private Tablero mat;
    private SpaceInvaders sc;
    private JPanel panelColores;
    private int widht;
    private int height;
    private SpaceInvadersGUI(){
        this.sc = new SpaceInvaders(500 , 500);  
        height = sc.getLenght() + 60;
        widht = sc.getWidth() + 15;
        setTitle("SpaceInvaders");
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        mat = new Tablero(sc);
        prepareElementos();
        prepareElementosMenu();
        prepareElementosTablero();
        prepareAcciones();
    }
    
    private void prepareElementos(){
        //tamaño y posicion de la ventana
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        Dimension d = new Dimension(widht , height);
        setSize(d);
        setLocation(screenWidth / 4,0);
        //menu clasico de la aplicacion
        setLayout(new BorderLayout());
        mb=new JMenuBar();
        setJMenuBar(mb);
        menu1=new JMenu("Menu");
        mb.add(menu1);
        //ventana de archivos
        chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Normal Text File", "txt");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
        chooser.setFileFilter(filter);
        chooser.setFileFilter(filter2);
        //tablero
        add(mat,BorderLayout.CENTER);
    }
    
    private void prepareElementosMenu(){
        //opciones del menuº
        mi1=new JMenuItem("Nuevo");
        menu1.add(mi1);
        mi2=new JMenuItem("Abrir");
        menu1.add(mi2);
        mi3=new JMenuItem("Salvar");
        menu1.add(mi3);
        mi4=new JMenuItem("Salvar como");
        menu1.add(mi4);
        mi5=new JMenuItem("Salir");
        menu1.add(mi5);
        
    }
    private void prepareElementosTablero(){
    }
   
    public void prepareAcciones(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev){
                salga();

            }
         });
        //menu
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
            }
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode()==39)
                {
                moverNaveDerecha();
                }

                else if (e.getKeyCode()==37)
                {
                moverNaveIzquierda();
                }
                else if (e.getKeyCode()==38)
                {
                disparar();
                }
                else if (e.getKeyCode()==40)
                {
                actualizar();
                }
            }
            public void keyReleased(KeyEvent e){
            }
        }
        );
    }
    
    public static void main(String args[]){
       SpaceInvadersGUI gui=new SpaceInvadersGUI();
       gui.setVisible(true);
     }   
       
    public void salga(){  
        int dialogButton = JOptionPane.YES_NO_OPTION;
        dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure?","SALIR", dialogButton);
        if(dialogButton == JOptionPane.YES_OPTION) {  
                    System.exit(0);
          }
    }
    
    /*
    *Acciones de las opciones de menu.
    */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==mi1) {
            System.out.println("nuevo");
        }
        //abrir
        if (e.getSource()==mi2) {
            int archivo = chooser.showOpenDialog(mi2);
            if(archivo == JFileChooser.APPROVE_OPTION) {
               System.out.println("Abrir: " + chooser.getSelectedFile().getName());
            }
        }
        //salvar
        if (e.getSource()==mi3) {
            int archivo = chooser.showSaveDialog(mi3);
            if(archivo == JFileChooser.APPROVE_OPTION) {
               System.out.println("Salvar: " + chooser.getSelectedFile().getName());
            }
        }
        if (e.getSource()==mi4) {
            System.out.println("salvar como");
        }  
        if (e.getSource()==mi5) {
            salga();
        } 

    }
    
    public void moverNaveDerecha(){
        sc.moverDerechaJ1();
        mat.repaint();
    }
    public void moverNaveIzquierda(){
        sc.moverIzquierdaJ1();
        mat.repaint();
    }
    public void disparar(){
        sc.dispararJ1();
        mat.repaint();
    }
    public void actualizar(){
        sc.actualizar();
        mat.repaint();
    }
 
}

class Tablero extends JPanel{
    private SpaceInvaders sc;
    public Tablero(SpaceInvaders sc) {
        setBackground(Color.black);
        this.sc = sc;
        setPreferredSize(new Dimension(sc.getLenght(), sc.getWidth())); 
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ArrayList<Rectangle> ob = sc.getOb();
        for (int i = 0 ; i < ob.size() ; i++){
            Rectangle re = ob.get(i);  
            if (re instanceof Extraterrestre){
                Extraterrestre e = (Extraterrestre) re;
                if (e.isVivo()){
                    g.setColor(Color.blue);
                    int h = (int) e.getHeight();
                    int w = (int) e.getWidth();
                    int x = (int) e.getX();
                    int y = (int) e.getY();
                    g.fillRect(x , y , w , h);
                }
            }
            else if (re instanceof Bala){
                Bala b = (Bala) re;
                if (b.isVivo()){
                    g.setColor(Color.white);
                    int h = (int) b.getHeight();
                    int w = (int) b.getWidth();
                    int x = (int) b.getX();
                    int y = (int) b.getY();
                    g.fillRect(x , y , w , h);
                }
            }
            else if (re instanceof Nave){
                Nave n = (Nave) re;
                if (n.isVivo()){
                    g.setColor(Color.green);
                    int h = (int) n.getHeight();
                    int w = (int) n.getWidth();
                    int x = (int) n.getX();
                    int y = (int) n.getY();
                    g.fillRect(x , y , w , h);
                }
            }
        }
    }
   
}