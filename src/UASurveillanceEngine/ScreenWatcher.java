package UASurveillanceEngine;


import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import javax.imageio.ImageWriter;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.IMediaData;

/**
 * 
 */
public class ScreenWatcher extends Watcher {

	private static final String OUTFILE = "/home/etudiant/vid/test.mp4"; //Connexion en FTP à mettre en place
	private static final int width=640, height=480; // 16*9 -> 768*432	

	
	/**
	 * Default constructor
	 */
	public ScreenWatcher() {
		isRecording = false;
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
	private IMediaWriter writer;

	/**
	 * 
	 */
	private boolean isRecording;

	/**
	 * @return
	 */
	private BufferedImage getScreenCapture() {
		 BufferedImage img = robot.createScreenCapture(area);
	     return img;
	}

	/**
	 * Convertit l'image source dans le bon format
	 * @param sourceImage - l'image retournée par getScreenCapture()
	 * @param targetType - Le format cible

	 * @return L'image convertie
	 */
	private BufferedImage convertToType(BufferedImage sourceImage, int targetType) {

        BufferedImage image;

        // Si l'image a déjà le bon type, ne rien faire

        if (sourceImage.getType() == targetType)
            image = sourceImage;

        // Sinon on refait l'image
        else {
            image = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), targetType);
            image.getGraphics().drawImage(sourceImage, 0, 0, null);
        }

        return image;
    }

	/**
	 * Indique si un enregistrement est en cours
	 * @return isRecording
	 */
	public boolean isRecording() {

		return isRecording;

	}


	/**
	 * Modifie l'état de l'enregistrement
	 * @param state l'état de l'enregistrement
	 */
	public void setRecording(boolean state) {

		this.isRecording = state;
	}

	/**
	 * 
	 */
	public void stopRecording() {
		this.isRecording=false;
	}

	/**
	 * 
	 */
	public void sendStream() {
		// TODO implement here
	}

	@Override
	public void run() {
		try {

			robot = new Robot();
			writer = ToolFactory.makeWriter(OUTFILE);
	        area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	        
	        writer.addVideoStream(area.x, area.y, ICodec.ID.CODEC_ID_MPEG4, width, height);

	        long startTime = System.nanoTime();

	        isRecording = true;

	        while (isRecording){

	            BufferedImage bgrScreen = getScreenCapture();
	            System.out.println("time stamp = "+ (System.nanoTime() - startTime));
	            bgrScreen = convertToType(bgrScreen, BufferedImage.TYPE_3BYTE_BGR);

	            writer.encodeVideo(0, bgrScreen, System.nanoTime() - startTime, TimeUnit.NANOSECONDS);

	            // Une image toutes les demi-secondes
	            try {
	                Thread.sleep((long) (500));
	            } catch (InterruptedException e) {
	            	}
	        }

	        writer.close();

		} catch (AWTException e1) {

			e1.printStackTrace();

		} finally {

			robot = null;
			writer = null;
			isRecording = false;
		}        

	}

}