

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * Clase PanelCamposInformacion.
 */
public class PanelCamposInformacion extends JPanel {
	
	/** The componente. */
	JComponent componente;
	
	/** The et nombre. */
	JLabel etNombre;
	
	/** The titulo. */
	JPanel titulo;
	
	/** The texto. */
	JPanel texto;
	
	/** The vertical box. */
	Box verticalBox;
	
	/**
	 * Instantiates a new panel campos informacion.
	 *
	 * @param componente the componente
	 * @param etNombre the et nombre
	 * @param colorFondo the color fondo
	 * @param tamano the tamano
	 * @param tamanoFuente the tamano fuente
	 */
	public PanelCamposInformacion(JComponent componente,JLabel etNombre,Color colorFondo,Dimension tamano,int tamanoFuente) {
		this.componente = componente;
		this.etNombre = etNombre;
		
		setBackground(colorFondo);
		
		verticalBox = Box.createVerticalBox();
		
		titulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titulo.setBackground(colorFondo);
		
		etNombre.setFont(new Font("Arial",1,(int) tamanoFuente));
		
		if(componente instanceof JPanel) {
			etNombre.setFont(new Font("Arial",1,tamanoFuente));
			
		}
		
		titulo.add(etNombre);
		
		texto = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		componente.setPreferredSize(new Dimension(tamano.width,tamano.height));
		
		
		
		texto.add(componente);
		texto.setBackground(colorFondo);
		
		verticalBox.add(titulo);
		verticalBox.add(texto);
		
		
		add(verticalBox);
		
		
	}
	

}
