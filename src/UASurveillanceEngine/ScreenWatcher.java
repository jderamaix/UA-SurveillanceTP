package UASurveillanceEngine;


import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import javax.imageio.ImageWriter;

/**
 * 
 */
public class ScreenWatcher extends Watcher {

	/**
	 * Default constructor
	 */
	public ScreenWatcher() {
	}

	/**
	 * 
	 */
	private Robot robot;

	/**
	 * 
	 */
	private Rectangle area;

	/**
	 * 
	 */
	private ImageWriter writer;

	/**
	 * 
	 */
	private boolean isRecording;

	/**
	 * @return
	 */
	private BufferedImage getScreenCapture() {
		// TODO implement here
		return null;
	}

	/**
	 * @param sourceImage 
	 * @param targetType 
	 * @return
	 */
	private BufferedImage convertToType(BufferedImage sourceImage, int targetType) {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public synchronized boolean isRecording() {
		// TODO implement here
		return false;
	}

	/**
	 * 
	 */
	public void startRecording() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void stopRecording() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void sendStream() {
		// TODO implement here
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}