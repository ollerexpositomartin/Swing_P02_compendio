

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.AbstractDocument.Content;


/**
 * Clase Panel2Der.
 */
public class Panel2Der extends JPanel {
	

	/** The vertical box. */
	Box verticalBox;
	
	/** The titulo imagenes. */
	JLabel tituloImagenes;
	
	/** The panel separacion. */
	JPanel panelSeparacion;
	
	/**
	 * Instantiates a new panel 2 der.
	 *
	 * @param imagen the imagen
	 * @param btnImgAnterior the btn img anterior
	 * @param btnImgSiguiente the btn img siguiente
	 * @param listaCamas the lista camas
	 * @param panelExtraNinos the panel extra ninos
	 */
	public Panel2Der(JLabel imagen,JButton btnImgAnterior,JButton btnImgSiguiente,Box listaCamas,Box panelExtraNinos) {
		Color colorFondo = Color.decode(Colores.COLOR1.getColor());
		
		setBackground(colorFondo);
		verticalBox = Box.createVerticalBox();
		
		
		//IMAGENES PISOS
	
		JPanel panelImagenBotones = new JPanel(new BorderLayout());
		panelImagenBotones.setBackground(colorFondo);
		
		imagen.setPreferredSize(new Dimension(350,250));
		JPanel panelImagen = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelImagen.setBackground(colorFondo);
		panelImagen.add(imagen);
		
		
		JPanel filaBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
		filaBotones.setBackground(colorFondo);
		btnImgAnterior.setBackground(colorFondo);
		btnImgSiguiente.setBackground(colorFondo);
		filaBotones.add(btnImgAnterior);
		filaBotones.add(btnImgSiguiente);
		
		panelImagenBotones.add(panelImagen,BorderLayout.CENTER);
		panelImagenBotones.add(filaBotones,BorderLayout.SOUTH);
		
		PanelCamposInformacion panelImagenCompleto = new PanelCamposInformacion(panelImagenBotones,new JLabel("Imagenes Pisos"), colorFondo,new Dimension(350,250),24);
		
		
		//TIPOS CAMA
		PanelCamposInformacion panelListaCamas = new PanelCamposInformacion(listaCamas,new JLabel("Lista de Camas"),Color.decode(Colores.COLOR4.getColor()),new Dimension(100,300),24);
		
		//PANEL SEPARACION
		panelSeparacion = new JPanel();
		panelSeparacion.setBackground(colorFondo);
	
		//PANEL NIÑOS
		PanelCamposInformacion panelTituloExtraNinos = new PanelCamposInformacion(panelExtraNinos,new JLabel("Extras Niños"),Color.decode(Colores.COLOR4.getColor()),new Dimension(200,140),24);

		
	
		
		verticalBox.add(panelImagenCompleto);
		verticalBox.add(Box.createGlue());
		verticalBox.add(panelListaCamas);
		verticalBox.add(Box.createGlue());
		verticalBox.add(panelSeparacion);
		verticalBox.add(Box.createGlue());
		verticalBox.add(panelTituloExtraNinos); 
		
		add(verticalBox);
	}

}
