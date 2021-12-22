


import java.awt.*;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;



/**
 * Clase PanelInformacion.
 */
public class PanelInformacion extends JPanel implements ActionListener {
	
	/** The informacion. */
	JLabel informacion;
	
	/** The baja pisos. */
	JButton altaPisos,bajaPisos;
	
	/** The im nuevo. */
	ImageIcon imBorrar,imNuevo;
	
	/** The panel info. */
	JPanel panelInfo;
	
	/** The panel inferior. */
	JPanel panelInferior;
	
	/** The vertical box. */
	Box verticalBox;
	
	/** The ventana dialogo alta pisos. */
	VentanaDialogoAltaPisos ventanaDialogoAltaPisos;
	
	/** The v. */
	VentanaPrincipal v;
	
	/**
	 * Instantiates a new panel informacion.
	 *
	 * @param v the v
	 */
	public PanelInformacion(VentanaPrincipal v) {
		this.v = v;
		
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		
		imBorrar = new ImageIcon(getClass().getResource("resources/borrar.png"));
		imNuevo = new ImageIcon(getClass().getResource("resources/nuevo.png"));
		
		
		verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(Color.white);
	
		panelInfo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelInfo.setBackground(Color.white);
		
		
		
		panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelInferior.setBackground(Color.white);
			
		altaPisos = new JButton(imNuevo);
		altaPisos.setBackground(Color.white);
		altaPisos.setMnemonic(KeyEvent.VK_A);
		altaPisos.addActionListener(this);
		
		
	
		bajaPisos = new JButton(imBorrar);
		bajaPisos.setBackground(Color.white);
		bajaPisos.setMnemonic(KeyEvent.VK_B);
		bajaPisos.addActionListener(this);
		
		
		informacion = new JLabel("<html>La empresa AlquileresOLLER es una empresa dedicada<br/>al arrendamiento de pisos turisticos por toda España<html>");
		informacion.setFont(new Font(altaPisos.getFont().getFontName(),0,24));
		
		
		
		panelInfo.add(informacion);
		verticalBox.add(Box.createVerticalGlue());
		verticalBox.add(panelInfo);
		verticalBox.add(Box.createVerticalGlue());
		
		panelInferior.add(altaPisos);
		panelInferior.add(bajaPisos);
		
		
		
		add(verticalBox,BorderLayout.CENTER);
		add(panelInferior,BorderLayout.SOUTH);
		
		
	}


	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bajaPisos) {
			JOptionPane.showOptionDialog(v,"Esta opción todavia no esta desarrollada" , "INFORMACION",JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new String []{"Aceptar"},null);
			
		}
		
		if(e.getSource()==altaPisos) {
			ventanaDialogoAltaPisos = new VentanaDialogoAltaPisos(v);
			ventanaDialogoAltaPisos.setVisible(true);
		}
		
	}
	


}
