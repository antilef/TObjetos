import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Jugador extends JPanel{
	static int posicion;
	public void paintComponent(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(600+Tablero.movIzquierda,600, 30, 30);
		posicion=600+Tablero.movIzquierda;
	}
}
