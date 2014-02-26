package fk;

/**
 * Die Klasse stellt eine Assoziation zwischen zwei KLasse dar.
 * @author Gruppe
 *
 */
public class Assoziation {
	private String name;
	private String multi1;
	private String multi2;
	private String klasse1;
	private String klasse2;
	/**
	 * Kostruktor zum Setzen von Attributen.
	 * @param name
	 * @param klasse1
	 * @param klasse2
	 * @param multi1
	 * @param multi2
	 */
	public Assoziation(String name, String klasse1, String klasse2, 
			String multi1, String multi2) {
		this.name = name;
		this.multi1 = multi1;
		this.multi2 = multi2;
		this.klasse1 = klasse1;
		this.klasse2 = klasse2;
		
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the multi1
	 */
	public String getMulti1() {
		return multi1;
	}
	/**
	 * @param multi1 the multi1 to set
	 */
	public void setMulti1(String multi1) {
		this.multi1 = multi1;
	}
	/**
	 * @return the multi2
	 */
	public String getMulti2() {
		return multi2;
	}
	/**
	 * @param multi2 the multi2 to set
	 */
	public void setMulti2(String multi2) {
		this.multi2 = multi2;
	}
	/**
	 * @return the klasse1
	 */
	public String getKlasse1() {
		return klasse1;
	}
	/**
	 * @param klasse1 the klasse1 to set
	 */
	public void setKlasse1(String klasse1) {
		this.klasse1 = klasse1;
	}
	/**
	 * @return the klasse2
	 */
	public String getKlasse2() {
		return klasse2;
	}
	/**
	 * @param klasse2 the klasse2 to set
	 */
	public void setKlasse2(String klasse2) {
		this.klasse2 = klasse2;
	}
}
