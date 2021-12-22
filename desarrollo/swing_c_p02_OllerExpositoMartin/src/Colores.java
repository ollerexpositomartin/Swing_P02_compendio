

/**
 * Clase Enum Colores.
 */
public enum Colores {
	
	/** COLOR1 */
	COLOR1("#21A6B6"),
	
	/** COLOR2 */
	COLOR2("#FA02B3"),
	
	/** COLOR3 */
	COLOR3("#D5B935"),
	
	/** COLOR4 */
	COLOR4("#F0E5C5"),
	
	/** COLOR5 */
	COLOR5("#0B134C");
	
	/** Atributo color*/
	private String color;
	
	/**
	 * Instancia Colores 
	 *
	 * @param COLORES
	 */
	Colores(String color) {
	this.color = color;
		
	}
	
	/**
	 * Obtiene el color
	 *
	 * @return El color elegido
	 */
	public String getColor() { return color; }
}
