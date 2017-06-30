import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Tablero extends JFrame{
	int numEnemy;
	ArrayList<Enemigo> listaEnemigos = new ArrayList<Enemigo>();
	Enemigo uno;
	static int movIzquierda=0;
	//posiciones aleatorias
	Jugador angelo;
	Random aleat= new Random();
	static int y;
	static int x;
	Disparo linea;
	int disparos;
	int acertados;
	public Tablero(){
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new Keyboard());
		numEnemy=validaEnemigos();
		disparos=numEnemy;
		for(int i=0;i<numEnemy;i++){
			int y=aleat.nextInt(500);
			int x=aleat.nextInt(550);
			listaEnemigos.add(new Enemigo());
			listaEnemigos.get(i).setBounds(x, y, 50, 50);
			add(listaEnemigos.get(i));
		}
		angelo= new Jugador();
		add(angelo);
		
		}
	public static int validaEnemigos(){
		boolean sigue =true;
		int numEnemy=0;
		String enemy = JOptionPane.showInputDialog("ingrese numero de enemigos").trim();
		while(sigue){
			try{
				numEnemy=Integer.parseInt(enemy);
				sigue=false;

			}catch (Exception NumberFormatException) {
				enemy = JOptionPane.showInputDialog("Error ingrese otra vez ").trim();
			}
		}
		return numEnemy;
	}
	
	public void  elimina(){
		
		for(int i=0;i<listaEnemigos.size();i++){
			if(((listaEnemigos.get(i).getX()+15)>angelo.posicion) && ((listaEnemigos.get(i).getX()-15)<angelo.posicion)   ){
				listaEnemigos.get(i).setVisible(false);
				acertados+=1;
			}
		}
		
	}
	
	
	
	//Manejo de Eventos
	class Keyboard implements KeyListener{
		boolean eliminar;
	    public void keyTyped(KeyEvent e){}
	    public void keyPressed(KeyEvent e){
	      // 37 = tecla flecha izquierda
	      // 32 = tecla espaciadora
	      if(e.getKeyCode()==37){
	        movIzquierda=movIzquierda-10;
	        repaint();
	      }else if(e.getKeyCode()==32){
	    	linea=new Disparo();
	    	add(linea);
	    	validate();
	    	repaint();
	    	elimina();
	    	disparos-=1;
	    	System.out.println(disparos);
	    	validate();
	    	repaint();
	      }
	    }
	    public void keyReleased(KeyEvent e){}
	  }
	
		//Enemigos
	  class Enemigo extends JPanel {
		  public void paintComponent(Graphics g){
			  g.setColor(Color.BLACK);
			  g.fillOval(0,0, 30,30);
		  }

	  }
}
