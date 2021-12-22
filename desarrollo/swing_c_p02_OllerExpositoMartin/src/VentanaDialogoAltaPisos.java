
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.text.MaskFormatter;
import javax.swing.event.ChangeListener;

/**
 * Clase VentanaDialogoAltaPisos.
 */
public class VentanaDialogoAltaPisos extends JDialog implements ActionListener, ChangeListener, FocusListener {

	/** The horizontal box. */
	Box horizontalBox;
	
	/** The alquiler oller. */
	JLabel alquilerOller;
	
	/** The panel. */
	Panel1 panel;
	
	/** The panel 2. */
	Panel2 panel2;
	
	/** The panel 3. */
	Panel3 panel3;
	
	/** The panel titulo. */
	JPanel panelBase, panelTitulo;
	
	/** The ta inmueble. */
	JTextArea taArrendador, taInmueble;

	/** The panel extra ninos. */
	Box cajaListaCamas, panelExtraNinos;

	/** The pos. */
	int pos = 0;
	
	/** The pos imagenes. */
	int[] posImagenes = { 1, 2, 3, 4 };

	/** The tf precio minimo. */
	JTextField tfNombre, tfApellidos, tfDni, tfTelefono, tfDireccion, tfExtrasNinos, tfPrecioMinimo;
	
	/** The jc provincias. */
	JComboBox<String> jcProvincias;
	
	/** The js edad ninos. */
	JSpinner jsFechaAlta, jsFechaDisponibilidad, jsNHuespedes, jsNDormitorios, jsNBanios, jsNCamas, jsEdadNinos;

	/** The btn nuevo. */
	JButton btnImgAnterior, btnImgSiguiente, btnGuardar, btnImprimir, btnNuevo;
	
	/** The precio minimo. */
	int camaDoble = 0,camaSofa = 0,camaSimple = 0, cuna = 0,camaSupletoria = 0,precioMinimo=0;
	
	/** The sl edad. */
	JSlider slEdad;

	/** The j CB ninos. */
	JCheckBox jCBNinos;

	/** The et edad. */
	JLabel imgPisos,etEdad;

	/** The tipo cama. */
	String[] tipoCama = { "Simple", "Doble", "Sofa-Cama" };

	/** The lista camas. */
	ArrayList<PanelCamposInformacion> listaCamas = new ArrayList<>();

	/**
	 * Instantiates a new ventana dialogo alta pisos.
	 *
	 * @param VentanaPrincipal the ventana principal
	 */
	public VentanaDialogoAltaPisos(JFrame VentanaPrincipal) {
		super(VentanaPrincipal, "Alta pisos", true);
		setIconImage(new ImageIcon(getClass().getResource("resources/casa.png")).getImage());

		Toolkit miPantalla = Toolkit.getDefaultToolkit();

		Dimension tamagnoPantalla = miPantalla.getScreenSize();

		int altoPantalla = tamagnoPantalla.height;
		int anchoPantalla = tamagnoPantalla.width;
		this.setSize(anchoPantalla, altoPantalla);
		setLocationRelativeTo(null);

		panelBase = new JPanel();
		panelBase.setLayout(new BorderLayout());
		panelBase.setBackground(Color.decode(Colores.COLOR5.getColor()));
		panelBase.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode(Colores.COLOR4.getColor())));

		panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelTitulo.setBackground(Color.decode(Colores.COLOR5.getColor()));

		alquilerOller = new JLabel("Alquileres OLLER");
		alquilerOller.setForeground(Color.white);
		alquilerOller.setFont(new Font("Agency FB", 1, 42));
		panelTitulo.add(alquilerOller);

		horizontalBox = Box.createHorizontalBox();

		iniciarPanel1();
		iniciarPanel2();
		iniciarPanel3();

		panelBase.add(panelTitulo, BorderLayout.NORTH);
		panelBase.add(horizontalBox, BorderLayout.CENTER);

		add(panelBase, BorderLayout.CENTER);

	}

	/**
	 * Inicializa los componentes del panel 1
	 */
	public void iniciarPanel1() {

		tfNombre = new JTextField();
		tfApellidos = new JTextField();

		try {
			tfDni = new JFormattedTextField(new MaskFormatter("########U"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			tfTelefono = new JFormattedTextField(new MaskFormatter("#########"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		etEdad = new JLabel("Edad: 18");
		slEdad = new JSlider(18,100);
		slEdad.setValue(18);
		slEdad.setToolTipText("Selecciona la edad del arrendador");
		slEdad.addChangeListener(this);

		panel = new Panel1(tfNombre, tfApellidos, tfDni, tfTelefono,etEdad,slEdad);
		horizontalBox.add(panel);

	}

	/**
	 * Inicializa los componentes del panel 2.
	 */
	public void iniciarPanel2() {

		String[] provincias = { "Alava", "Albacete", "Alicante", "Almería", "Asturias", "Avila", "Badajoz", "Barcelona",
				"Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "La Coruña", "Cuenca",
				"Gerona", "Granada", "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Islas Baleares", "Jaén", "León",
				"Lérida", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Orense", "Palencia", "Las Palmas",
				"Pontevedra", "La Rioja", "Salamanca", "Segovia", "Sevilla", "Soria", "Tarragona",
				"Santa Cruz de Tenerife", "Teruel", "Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora",
				"Zaragoza" };

		// CAMPO DIRECCION
		tfDireccion = new JTextField();

		// COMBO BOX PROVINCIA
		jcProvincias = new JComboBox<String>(provincias);

		// FECHAS
		jsFechaAlta = new JSpinner(new SpinnerDateModel());
		jsFechaDisponibilidad = new JSpinner(new SpinnerDateModel());
		Date fechaAnioMas = (Date) jsFechaAlta.getValue();
		fechaAnioMas.setYear(fechaAnioMas.getYear() + 1);
		jsFechaDisponibilidad.setValue(fechaAnioMas);

		// NUMEROS HUESPEDES
		jsNHuespedes = new JSpinner(new SpinnerNumberModel(0, 0, 8, 1));

		// NUMEROS DORMITORIOS
		jsNDormitorios = new JSpinner(new SpinnerNumberModel(0, 0, 4, 1));

		// NUMEROS BAÑOS
		jsNBanios = new JSpinner(new SpinnerNumberModel(0, 0, 2, 1));

		// PANEL IMAGENES
		imgPisos = new JLabel(new ImageIcon(getClass().getResource("resources/imagen" + posImagenes[pos] + ".jpg")));
		btnImgAnterior = new JButton(new ImageIcon(getClass().getResource("resources/flechaIzq.png")));
		btnImgAnterior.setPreferredSize(new Dimension(50, 50));
		btnImgAnterior.addActionListener(this);

		btnImgSiguiente = new JButton(new ImageIcon(getClass().getResource("resources/flechaDer.png")));
		btnImgSiguiente.setPreferredSize(new Dimension(50, 50));
		btnImgSiguiente.addActionListener(this);

		// PANEL CAMAS
		jsNCamas = new JSpinner(new SpinnerNumberModel(0, 0, 4, 1));
		jsNCamas.addChangeListener(this);

		cajaListaCamas = Box.createVerticalBox();
		rellenarListaCamas();

		// PANEL NIÑOS
		jCBNinos = new JCheckBox();
		jCBNinos.addActionListener(this);

		panelExtraNinos = Box.createVerticalBox();

		jsEdadNinos = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		tfExtrasNinos = new JTextField();
		tfExtrasNinos.addFocusListener(this);
		tfExtrasNinos.setEditable(false);

		PanelCamposInformacion panelEdadNinos = new PanelCamposInformacion(jsEdadNinos, new JLabel("Edad Niños"),
				Color.decode(Colores.COLOR4.getColor()), new Dimension(100, 20), 18);
		PanelCamposInformacion panelExtras = new PanelCamposInformacion(tfExtrasNinos, new JLabel("Extra"),
				Color.decode(Colores.COLOR4.getColor()), new Dimension(200, 20), 18);

		panelExtraNinos.add(panelEdadNinos);
		panelExtraNinos.add(panelExtras);

		jsEdadNinos.setEnabled(jCBNinos.isSelected());
		tfExtrasNinos.setEnabled(jCBNinos.isSelected());

		// PRECIO MINIMO
		tfPrecioMinimo = new JTextField();
		tfPrecioMinimo.addFocusListener(this);

		panel2 = new Panel2(tfDireccion, jcProvincias, jsFechaAlta, jsFechaDisponibilidad, jsNHuespedes, jsNDormitorios,
				jsNBanios, imgPisos, btnImgAnterior, btnImgSiguiente, cajaListaCamas, jsNCamas, jCBNinos,
				panelExtraNinos, tfPrecioMinimo);
		horizontalBox.add(panel2);

	}

	/**
	 * Inicializa los componentes del panel 3
	 */
	public void iniciarPanel3() {

		btnGuardar = new JButton(new ImageIcon(getClass().getResource("resources/guardar.png")));
		btnGuardar.addActionListener(this);

		btnImprimir = new JButton(new ImageIcon(getClass().getResource("resources/imprimir.png")));
		btnImprimir.addActionListener(this);

		btnNuevo = new JButton(new ImageIcon(getClass().getResource("resources/nuevo.png")));
		btnNuevo.addActionListener(this);

		taArrendador = new JTextArea();
		taArrendador.setFont(new Font("Arial",0,18));
		taArrendador.setEditable(false);

		taInmueble = new JTextArea();
		taInmueble.setFont(new Font("Arial",0,18));
		taInmueble.setEditable(false);

		panel3 = new Panel3(btnGuardar, btnImprimir, btnNuevo, taArrendador, taInmueble);
		horizontalBox.add(panel3);

	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnImgSiguiente) {

			if (pos == posImagenes.length - 1) {
				pos = 0;
				imgPisos.setIcon(
						new ImageIcon(getClass().getResource("resources/imagen" + posImagenes[pos] + ".jpg")));
				return;
			}

			pos += 1;
			imgPisos.setIcon(new ImageIcon(getClass().getResource("resources/imagen" + posImagenes[pos] + ".jpg")));

		}

		if (e.getSource() == btnImgAnterior) {

			if (pos == 0) {
				pos = posImagenes.length - 1;
				imgPisos.setIcon(
						new ImageIcon(getClass().getResource("../resources/imagen" + posImagenes[pos] + ".jpg")));
				return;
			}

			pos -= 1;
			imgPisos.setIcon(new ImageIcon(getClass().getResource("../resources/imagen" + posImagenes[pos] + ".jpg")));

		}

		if (e.getSource() == jCBNinos) {

			ninosActivado();

		}

		if (e.getSource() == btnNuevo) {

			// Limpiamos los campos y establecemos los spinner y los jcomboBox a 0
			tfNombre.setText("");
			tfNombre.setBorder(null);
			tfApellidos.setText("");
			tfApellidos.setBorder(null);
			tfDni.setText(null);
			tfDni.setBorder(null);
			tfTelefono.setText("");
			tfTelefono.setBorder(null);
			etEdad.setText("Edad: 18");
			slEdad.setValue(18);
			tfDireccion.setText("");
			tfDireccion.setBorder(null);
			jcProvincias.setSelectedIndex(0);

			jsNHuespedes.setValue(0);
			jsNHuespedes.setBorder(null);
			jsNDormitorios.setValue(0);
			jsNDormitorios.setBorder(null);
			jsNBanios.setValue(0);
			jsNBanios.setBorder(null);
			jsNCamas.setValue(0);
			jsNCamas.setBorder(null);
			jCBNinos.setSelected(false);
			tfPrecioMinimo.setText("");
			taArrendador.setText("");
			taInmueble.setText("");
			

			ninosActivado();

			// Actualizamos la fecha
			jsFechaAlta.setValue(new JSpinner(new SpinnerDateModel()).getValue());
			Date fechaAnioMas = (Date) jsFechaAlta.getValue();
			fechaAnioMas.setYear(fechaAnioMas.getYear() + 1);
			jsFechaDisponibilidad.setValue(fechaAnioMas);

			tfNombre.requestFocus();

		}

		if (e.getSource() == btnGuardar) {

			if (CamposRellenados()) {

				JOptionPane.showOptionDialog(this, "Registro Guardado", "INFORMACION", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Aceptar" }, null);
				return;
			}

			JOptionPane.showOptionDialog(this, "Tienes que rellenar todos los campos marcados en Rojo", "ERROR",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Aceptar" }, null);

		}

		if (e.getSource() == btnImprimir) {

			if (CamposRellenados()) {
				calcularPrecioCamas();
				imprimirArrendador();
				imprimirInmueble();
				
				return;
			}
			JOptionPane.showOptionDialog(this, "Tienes que rellenar todos los campos marcados en Rojo", "ERROR",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Aceptar" }, null);


		}

	}

	/**
	 * State changed.
	 *
	 * @param e the e
	 */
	@Override
	public void stateChanged(ChangeEvent e) {

		if (e.getSource() == jsNCamas) {
			eliminarComponentesCama();
			validate();
			repaint();

			for (int i = 0; i < (Integer) jsNCamas.getValue(); i++) {
				cajaListaCamas.add(listaCamas.get(i));
				validate();
				repaint();

			}
		}
		
		
		if(e.getSource() == slEdad) {
			
			etEdad.setText("Edad: "+slEdad.getValue());
			
		}
		

	}

	/**
	 * Focus gained.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == tfExtrasNinos) {

			if ((Integer) jsEdadNinos.getValue() <= 3) {
				tfExtrasNinos.setText("cuna");
			} else {
				tfExtrasNinos.setText("cama supletoria pequeña");
			}

		}

		if (e.getSource() == tfPrecioMinimo) {
			
			calcularPrecioCamas();
			tfPrecioMinimo.setText(precioMinimo + "€");

		}

	}

	/**
	 * Focus lost.
	 *
	 * @param e the e
	 */
	@Override
	public void focusLost(FocusEvent e) {

	}

	/**
	 * Obtener camas adultos.
	 *
	 * @return ArrayList con las camas de los adultos
	 */
	private ArrayList<JComboBox<String>> obtenerCamasAdultos() {
		Component[] paneles = cajaListaCamas.getComponents();

		Component[] componentesTemp;
		ArrayList<JComboBox<String>> camas = new ArrayList<>();

		for (int i = 0; i < paneles.length; i++) {

			componentesTemp = ((Container) paneles[i]).getComponents();

			for (int j = 0; j < componentesTemp.length; j++) {

				componentesTemp = ((Container) componentesTemp[j]).getComponents();

				for (int j2 = 0; j2 < componentesTemp.length; j2++) {

					if (componentesTemp[j2] instanceof JComboBox<?>)
						camas.add((JComboBox<String>) componentesTemp[j2]);
				}

			}

		}

		return camas;

	}

	/**
	 * Activa y desactiva los componentes del panel niños y en caso de esta desactivado los limpia
	 */
	private void ninosActivado() {
		jsEdadNinos.setEnabled(jCBNinos.isSelected());
		tfExtrasNinos.setEnabled(jCBNinos.isSelected());

		if (!jCBNinos.isSelected())
			jsEdadNinos.setValue(0);
		tfExtrasNinos.setText("");

	}

	/**
	 * Rellena la lista de camas
	 */
	private void rellenarListaCamas() {

		for (int i = 0; i < 4; i++) {
			listaCamas.add(new PanelCamposInformacion(new JComboBox<String>(tipoCama), new JLabel("Cama " + (i + 1)),
					Color.decode(Colores.COLOR4.getColor()), new Dimension(100, 20), 18));
		}

	}

	/**
	 * Elimina todas las camas del Box cajaListaCamas
	 */
	private void eliminarComponentesCama() {
		Component[] componentes = cajaListaCamas.getComponents();

		for (Component component : componentes) {
			cajaListaCamas.remove(component);
		}

	}

	/**
	 * Comprueba si los campos estan rellenados
	 *
	 * @return the boolean
	 */
	private Boolean CamposRellenados() {
		Boolean valido = true;

		ArrayList<JTextField> camposTexto = new ArrayList<>();
		camposTexto.add(tfNombre);
		camposTexto.add(tfApellidos);
		camposTexto.add(tfDni);
		camposTexto.add(tfTelefono);
		camposTexto.add(tfDireccion);

		ArrayList<JSpinner> selectoresCantidad = new ArrayList<>();
		selectoresCantidad.add(jsNHuespedes);
		selectoresCantidad.add(jsNBanios);
		selectoresCantidad.add(jsNCamas);
		selectoresCantidad.add(jsNDormitorios);

		for (JTextField campoTexto : camposTexto) {

			String texto = campoTexto.getText().trim();

			if (texto.isEmpty()) {
				valido = false;
				campoTexto.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.red));
			} else {
				campoTexto.setBorder(null);
			}
		}

		for (JSpinner selectorCantidad : selectoresCantidad) {

			int valor = (int) selectorCantidad.getValue();

			if (valor == 0) {
				valido = false;
				selectorCantidad.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.red));
			} else {
				selectorCantidad.setBorder(null);
			}

		}

		return valido;

	}

	/**
	 * Imprime en el cuarto panel los datos del arrendador
	 */
	private void imprimirArrendador() {
		
		taArrendador.setText(
				
				"NOMBRE: "+tfNombre.getText()+"\n"
			+	"APELLIDOS: "+tfApellidos.getText()+"\n"
			+   "DNI: "+tfDni.getText()+"\n"
			+   "TELEFONO: "+tfTelefono.getText()+"\n"
			+	"EDAD: "+slEdad.getValue()+"\n"		
				);
		
	}
	
/**
 * Imprimir en el cuarto panel los datos del inmueble
 */
private void imprimirInmueble() {
		
		taInmueble.setText(
				
				"DIRECCION: "+tfDireccion.getText()+"\n"
			+	"PROVINCIA: "+jcProvincias.getSelectedItem()+"\n"
			+   "FECHA ALTA: "+jsFechaAlta.getValue()+"\n"
			+	"FECHA FINAL: "+jsFechaDisponibilidad.getValue()+"\n"
			+   "Numero Huespedes: "+jsNHuespedes.getValue()+"\n"
			+   "Numero Dormitorios: "+jsNDormitorios.getValue()+"\n"
			+   "Numero Baños: "+jsNBanios.getValue()+"\n"
			+	"Numero Camas: "+jsNCamas.getValue()+"\n"
			+   "\nTipo de camas Elegidos\n"
			+   "Camas Simple: "+camaSimple+"\n"
			+   "Camas Dobles: "+camaDoble+"\n"
			+   "Sofa Cama: "+camaSofa+"\n"
			+   "Cuna: "+cuna+"\n"
			+	"Cama Supletoria: "+camaSupletoria+"\n"
				);
		
		if(jCBNinos.isSelected()) {
			taInmueble.setText(
					taInmueble.getText()+"\n"
					+"¿Niños?: SI"
					
					);
			return;
		}
		
		
	   taInmueble.setText(
					taInmueble.getText()+"\n"
					+"¿Niños?: NO"	
				);
		
		
		
	}

/**
 * Calcula el precio minimo y las camas seleccionadas
 */
private void calcularPrecioCamas() {
	 camaDoble = 0;
	 camaSofa = 0;
	 camaSimple = 0;
	 cuna = 0;
	 camaSupletoria = 0;
	 
	 int bano = (int) jsNBanios.getValue();
	 
	 int precioCamaDoble = 0;
	 int precioCamaSofa = 0;
	 int precioCamaSimple = 0;
	 int precioCuna = 0;
	 int precioCamaSupletoria = 0;
	 int precioBano = 0;
	 
	
	precioMinimo = 0;

	ArrayList<JComboBox<String>> camas = obtenerCamasAdultos();

	for (JComboBox<String> cama : camas) {

		switch ((String) cama.getSelectedItem()) {

		case "Simple":
			camaSimple += 1;

			break;

		case "Doble":
			camaDoble += 1;

			break;

		case "Sofa-Cama":
			camaSofa += 1;

			break;
		}

	}

	if (tfExtrasNinos.getText().equalsIgnoreCase("cuna")) {
		cuna += 1;
	}
	if (tfExtrasNinos.getText().equalsIgnoreCase("cama supletoria pequeña")) {
		camaSupletoria += 1;
	}

	precioCamaSimple = camaSimple * 15;
	precioCamaDoble = camaDoble * 20;
	precioCamaSofa = camaSofa * 15;
	precioBano = bano * 25;
	precioCuna = cuna * 12;
	precioCamaSupletoria = camaSupletoria * 12;
	
	precioMinimo = precioCamaSimple + precioCamaDoble + precioCamaSofa + precioBano + precioCuna + precioCamaSupletoria;
	
}
	
		
}
