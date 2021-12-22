

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Clase PanelTituloImagen.
 */
public class PanelTituloImagen extends JPanel {
	
	/** The et imagen. */
	JLabel etImagen;
	
	/** The imagen. */
	ImageIcon imagen;
	
	
	/**
	 * Instantiates a new panel titulo imagen.
	 */
	public PanelTituloImagen() {
		
		setBackground(Color.decode(Colores.COLOR1.getColor()));
	
		imagen = new ImageIcon(getClass().getResource("resources/casa.png"));
		etImagen = new JLabel(imagen);
		
		add(etImagen,BorderLayout.CENTER);
		
	}

}
