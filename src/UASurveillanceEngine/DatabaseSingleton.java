package UASurveillanceEngine;


/**
 * 
 */
public class DatabaseSingleton {

	/**
	 * Default constructor
	 */
	public DatabaseSingleton() {
	}

	/**
	 * 
	 */
	private static DatabaseSingleton instance = null;

	/**
	 * 
	 */
	private String nom;

	/**
	 * 
	 */
	private String prenom;


	/**
	 * @return
	 */
	public static synchronized DatabaseSingleton getInstance() {
		return null;
	}

	/**
	 * 
	 */
	public void connect() {
		// TODO implement here
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}