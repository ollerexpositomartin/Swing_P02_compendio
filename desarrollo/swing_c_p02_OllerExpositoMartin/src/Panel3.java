

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * Clase Panel3.
 */
public class Panel3 extends JPanel {

	/** The panel pestanas. */
	JTabbedPane panelPestanas;
	
	/** The panel inmueble. */
	JPanel panelArrendador,panelInmueble;; 
	
	/** The panel botones. */
	Box panelBotones;
	
	/** The color fondo. */
	Color colorFondo;
	
	
	/**
	 * Instantiates a new panel 3.
	 *
	 * @param btnGuardar the btn guardar
	 * @param btnImprimir the btn imprimir
	 * @param btnNuevo the btn nuevo
	 * @param taArrendador the ta arrendador
	 * @param taInmueble the ta inmueble
	 */
	public Panel3(JButton btnGuardar, JButton btnImprimir, JButton btnNuevo, JTextArea taArrendador, JTextArea taInmueble) {
		colorFondo = Color.decode(Colores.COLOR2.getColor());
		setBackground(colorFondo);
		
		setLayout(new BorderLayout());
		
		panelPestanas = new JTabbedPane();
		
		panelArrendador = new JPanel(new BorderLayout());
		panelArrendador.add(taArrendador,BorderLayout.CENTER);
		
		panelInmueble = new JPanel(new BorderLayout());
		panelInmueble.add(taInmueble,BorderLayout.CENTER);
		
		
		panelPestanas.addTab("Arrendador",panelArrendador);
		panelPestanas.addTab("Inmueble", panelInmueble);

		
		
		panelBotones = Box.createVerticalBox();
		
		btnImprimir.setBackground(colorFondo);
		panelBotones.add(btnImprimir);
	
		btnNuevo.setBackground(colorFondo);
		panelBotones.add(btnNuevo);
		
		btnGuardar.setBackground(colorFondo);
		panelBotones.add(btnGuardar);
		
		

		add(panelPestanas, BorderLayout.CENTER);
		add(panelBotones,BorderLayout.EAST);
		

	}
}
