

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 * Clase Panel2.
 */
public class Panel2 extends JPanel {

	/** The panel izq. */
	Panel2Izq panelIzq;
	
	/** The panel der. */
	Panel2Der panelDer;

	/**
	 * Instantiates a new panel 2.
	 *
	 * @param tfDireccion the tf direccion
	 * @param jcProvincias the jc provincias
	 * @param jsFechaAlta the js fecha alta
	 * @param jsFechaDisponibilidad the js fecha disponibilidad
	 * @param jsNHuespedes the js N huespedes
	 * @param jsNDormitorios the js N dormitorios
	 * @param jsNBanios the js N banios
	 * @param imgPisos the img pisos
	 * @param btnImgAnterior the btn img anterior
	 * @param btnImgSiguiente the btn img siguiente
	 * @param listaCamas the lista camas
	 * @param jsNCamas the jsNcamas
	 * @param jCBNinos the j CB ninos
	 * @param panelExtraNinos the panel extra ninos
	 * @param tfprecioMinimo the tfprecio minimo
	 */
	public Panel2(JTextField tfDireccion, JComboBox<String> jcProvincias, JSpinner jsFechaAlta,
			JSpinner jsFechaDisponibilidad, JSpinner jsNHuespedes, JSpinner jsNDormitorios, JSpinner jsNBanios,
			JLabel imgPisos, JButton btnImgAnterior, JButton btnImgSiguiente, Box listaCamas, JSpinner jsNCamas,
			JCheckBox jCBNinos, Box panelExtraNinos, JTextField tfprecioMinimo) {

		setLayout(new GridLayout(1, 2));

		// PANEL IZQUIERDO
		panelIzq = new Panel2Izq(tfDireccion, jcProvincias, jsFechaAlta, jsFechaDisponibilidad, jsNHuespedes,
				jsNDormitorios, jsNBanios, jsNCamas, jCBNinos, tfprecioMinimo);

		// PANEL DERECHO
		panelDer = new Panel2Der(imgPisos, btnImgAnterior, btnImgSiguiente, listaCamas, panelExtraNinos);

		add(panelIzq);
		add(panelDer);

	}

}
