

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;


/**
 * Clase Panel1.
 */
public class Panel1 extends JPanel {
	
	/** The tf telefono. */
	JTextField tfNombre,tfApellidos,tfDni,tfTelefono;
	
	/** The vertical box. */
	Box verticalBox;
	
	/** The color fondo. */
	Color colorFondo;
	
	
		/**
		 * Instantiates a new panel 1.
		 *
		 * @param tfNombre the tf nombre
		 * @param tfApellidos the tf apellidos
		 * @param tfDni the tf dni
		 * @param tfTelefono the tf telefono
		 * @param etEdad the et edad
		 * @param slEdad the sl edad
		 */
		public Panel1(JTextField tfNombre,JTextField tfApellidos,JTextField tfDni,JTextField tfTelefono,JLabel etEdad,JSlider slEdad) {
			this.tfNombre = tfNombre;
			this.tfApellidos = tfApellidos;
			this.tfDni = tfDni;
			this.tfTelefono = tfTelefono;
			
			colorFondo = Color.decode(Colores.COLOR3.getColor());
			
			setBackground(colorFondo);
			
			
			verticalBox = Box.createVerticalBox();
			verticalBox.add(Box.createGlue());
			
			PanelCamposInformacion panel1 = new PanelCamposInformacion(tfNombre,new JLabel("Nombre"),colorFondo,new Dimension(300,35),24);
			verticalBox.add(panel1);
			verticalBox.add(Box.createGlue());
			
			PanelCamposInformacion panel2 = new PanelCamposInformacion(tfApellidos,new JLabel("Apellidos"),colorFondo,new Dimension(300,35),24);
			verticalBox.add(panel2);
			verticalBox.add(Box.createGlue());
			
			PanelCamposInformacion panel3 = new PanelCamposInformacion(tfDni,new JLabel("DNI"),colorFondo,new Dimension(300,35),24);
			verticalBox.add(panel3);
			verticalBox.add(Box.createGlue());
			
			PanelCamposInformacion panel4 = new PanelCamposInformacion(tfTelefono,new JLabel("Telefono"),colorFondo,new Dimension(300,35),24);
			verticalBox.add(panel4);
			verticalBox.add(Box.createGlue());
			
			
			
			PanelCamposInformacion panel5 = new PanelCamposInformacion(slEdad,etEdad,colorFondo,new Dimension(300,20),24);
			slEdad.setBackground(colorFondo);
			verticalBox.add(panel5);
			verticalBox.add(Box.createGlue());
			
			
			
			
			
			
			add(verticalBox);
		
			
			
			
		}
	

}
