package UASurveillanceEngine;


/**
 * 
 */
public abstract class Watcher extends Thread {

	/**
	 * Default constructor
	 */
	public Watcher() {
	}

	/**
	 * 
	 */
	private String type;

	/**
	 * 
	 */
	protected DatabaseSingleton db;


	/**
	 * @param msg 
	 * @return
	 */
	public boolean sendEvent(String msg) {
		// TODO implement here
		return false;
	}

}