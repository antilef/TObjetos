import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Disparo extends JPanel{
	static int posicion;
	public void paintComponent(Graphics g){
		g.drawLine(600+Tablero.movIzquierda+15,0,600+Tablero.movIzquierda+15,700);
	}
}
