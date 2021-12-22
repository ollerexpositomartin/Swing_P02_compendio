import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Clase VentanaPrincipal.
 */
public class VentanaPrincipal extends JFrame implements ActionListener{
	
	/** The menu bar. */
	JMenuBar menuBar;
	
	/** The ayuda. */
	JMenu archivo,registro,ayuda;
	
	/** The acerca de. */
	JMenuItem salir,altaPisos,bajaPisos,acercaDe;
	
	/** The panel titulo imagen. */
	PanelTituloImagen panelTituloImagen;
	
	/** The panel informacion. */
	PanelInformacion panelInformacion;
	
	/** The ventana dialogo alta pisos. */
	VentanaDialogoAltaPisos ventanaDialogoAltaPisos;
	
	/**
	 * Instantiates a new ventana principal.
	 */
	public VentanaPrincipal() {
		super("Gestión Apartamentos Turisticos AlquileresOLLER");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("resources/casa.png")).getImage());
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
	
		Dimension tamagnoPantalla = miPantalla.getScreenSize();

		int altoPantalla = tamagnoPantalla.height;
		int anchoPantalla = tamagnoPantalla.width;
		
		this.setSize(anchoPantalla / 2, altoPantalla / 2);
		this.setLocation(anchoPantalla / 4, altoPantalla / 4);
		iniciarComponentesMenu();
		
		panelTituloImagen = new PanelTituloImagen();
		
		panelInformacion = new PanelInformacion(this);
		
		add(panelTituloImagen,BorderLayout.NORTH);
		
		add(panelInformacion,BorderLayout.CENTER);
		

		
	}

	/**
	 * Inicializa los componentes del menu
	 */
	private void iniciarComponentesMenu() {
		
		salir = new JMenuItem("Salir");
		salir.addActionListener(this);
		
		altaPisos = new JMenuItem("Alta Pisos");
		altaPisos.addActionListener(this);
		
		bajaPisos = new JMenuItem("Baja Pisos");
		bajaPisos.addActionListener(this);
		
		acercaDe = new JMenuItem("Acerca de ...");
		acercaDe.addActionListener(this);
		
		archivo = new JMenu("Archivo");
		registro = new JMenu("Registro");
		ayuda = new JMenu("Ayuda");
		
		archivo.add(salir);
		registro.add(altaPisos);
		registro.add(bajaPisos);
		registro.setMnemonic(KeyEvent.VK_R);
		ayuda.add(acercaDe);
		
		menuBar = new JMenuBar();
		menuBar.add(archivo);
		menuBar.add(registro);
		menuBar.add(ayuda);
		
		setJMenuBar(menuBar);
		
	}

	
	
	
	
	
	
	
	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==salir) {
			dispose();
		}
		
		if(e.getSource()==bajaPisos) {
			JOptionPane.showOptionDialog(this,"Esta opción todavia no esta desarrollada" , "INFORMACION",JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new String []{"Aceptar"},null);
			
		}
		
		if(e.getSource()==altaPisos) {
			ventanaDialogoAltaPisos = new VentanaDialogoAltaPisos(this);
			ventanaDialogoAltaPisos.setVisible(true);
		}
		
		
		if(e.getSource()==acercaDe) {
			JOptionPane.showOptionDialog(this,"Nombre Empresa: AlquileresOLLER\n Info Empresa: Esta es una Empresa dedicada al\n alquiler de pisos turisticos en toda ESPAÑA" , "INFORMACION",JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new String []{"Aceptar"},null);
			
		}
		
		
		
	}
		
	
}
