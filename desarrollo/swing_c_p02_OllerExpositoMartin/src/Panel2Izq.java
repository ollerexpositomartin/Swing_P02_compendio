

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 * Clase Panel2Izq.
 */
public class Panel2Izq extends JPanel {

	/** The vertical box. */
	Box verticalBox;
	
	/** The tf direccion. */
	JTextField tfDireccion;
	
	/** The color fondo. */
	Color colorFondo;
	
	/** The panel fechas. */
	JPanel panelFechas;
	
	/** The panel ninos. */
	JPanel panelNinos;
	
	/** The et ninos. */
	JLabel etNinos;
	
	/** The panel separacion. */
	JPanel panelSeparacion;

	/**
	 * Instantiates a new panel 2 izq.
	 *
	 * @param tfDireccion the tf direccion
	 * @param jcProvincias the jc provincias
	 * @param jsFechaAlta the js fecha alta
	 * @param jsFechaDisponibilidad the js fecha disponibilidad
	 * @param jsNHuespedes the js N huespedes
	 * @param jsNDormitorios the js N dormitorios
	 * @param jsNBanios the js N banios
	 * @param jsNCamas the js N camas
	 * @param jCBNinos the j CB ninos
	 * @param tfPrecioMinimo the tf precio minimo
	 */
	public Panel2Izq(JTextField tfDireccion, JComboBox<String> jcProvincias, JSpinner jsFechaAlta,
			JSpinner jsFechaDisponibilidad, JSpinner jsNHuespedes, JSpinner jsNDormitorios, JSpinner jsNBanios,
			JSpinner jsNCamas, JCheckBox jCBNinos, JTextField tfPrecioMinimo) {

		colorFondo = Color.decode(Colores.COLOR1.getColor());
		setBackground(colorFondo);

		// CAMPO DIRECCION
		verticalBox = Box.createVerticalBox();
		PanelCamposInformacion panelDireccion = new PanelCamposInformacion(tfDireccion, new JLabel("Direccion"),
				colorFondo, new Dimension(300, 30), 24);
		verticalBox.add(panelDireccion);
		verticalBox.add(Box.createGlue());

		// CAMPO PROVINCIAS
		PanelCamposInformacion panelProvincias = new PanelCamposInformacion(jcProvincias, new JLabel("Provincias"),
				colorFondo, new Dimension(300, 30), 24);
		verticalBox.add(panelProvincias);
		verticalBox.add(Box.createGlue());

		// FECHAS
		panelFechas = new JPanel();
		panelFechas.setLayout(new GridLayout(1, 2));
		PanelCamposInformacion panelFechaInicio = new PanelCamposInformacion(jsFechaAlta, new JLabel("Fecha Alta"),
				colorFondo, new Dimension(100, 30), 18);
		PanelCamposInformacion panelFechaDisponibilidad = new PanelCamposInformacion(jsFechaDisponibilidad,
				new JLabel("Fecha final"), colorFondo, new Dimension(100, 30), 18);
		panelFechas.add(panelFechaInicio);
		panelFechas.add(panelFechaDisponibilidad);

		PanelCamposInformacion PanelFechasTitulo = new PanelCamposInformacion(panelFechas, new JLabel("Fechas"),
				colorFondo, new Dimension(220, 100), 24);

		verticalBox.add(PanelFechasTitulo);
		verticalBox.add(Box.createGlue());

		// CAMPO HUESPEDES
		PanelCamposInformacion panelHuespedes = new PanelCamposInformacion(jsNHuespedes,
				new JLabel("Numero de huespedes"), colorFondo, new Dimension(50, 30), 24);
		verticalBox.add(panelHuespedes);
		verticalBox.add(Box.createGlue());

		// CAMPO DORMITORIOS
		PanelCamposInformacion panelDormitorios = new PanelCamposInformacion(jsNDormitorios,
				new JLabel("Numero de Dormitorios"), colorFondo, new Dimension(50, 30), 24);
		verticalBox.add(panelDormitorios);
		verticalBox.add(Box.createGlue());

		// CAMPOS BANIOS
		PanelCamposInformacion panelBanios = new PanelCamposInformacion(jsNBanios, new JLabel("Numero de Baños"), colorFondo,
				new Dimension(50, 30), 24);
		verticalBox.add(panelBanios);
		verticalBox.add(Box.createGlue());

		// CAMPOS CAMAS
		PanelCamposInformacion panelCamas = new PanelCamposInformacion(jsNCamas, new JLabel("Numero de Camas"),
				colorFondo, new Dimension(50, 30), 24);
		verticalBox.add(panelCamas);
		verticalBox.add(Box.createGlue());

	
		// CAMPO NIÑOS
		panelNinos = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelNinos.setBackground(colorFondo);
		etNinos = new JLabel("¿Niños?");
		etNinos.setFont(new Font("Arial", 1, 24));
		jCBNinos.setBackground(colorFondo);
		panelNinos.add(etNinos);
		panelNinos.add(jCBNinos);

		verticalBox.add(panelNinos);
		verticalBox.add(Box.createGlue());

		// PANEL SEPARACION 
		panelSeparacion = new JPanel();
		panelSeparacion.setBackground(colorFondo);
		verticalBox.add(panelSeparacion);
		verticalBox.add(Box.createGlue());

		// CAMPO PRECIO MINIMO
		PanelCamposInformacion panelPrecioMinimo = new PanelCamposInformacion(tfPrecioMinimo,
				new JLabel("Precio Minimo"), colorFondo, new Dimension(200, 35), 24);
		verticalBox.add(panelPrecioMinimo);
		verticalBox.add(Box.createGlue());

		add(verticalBox);
	}

}
