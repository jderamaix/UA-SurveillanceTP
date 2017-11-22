package UASurveillanceEngine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;


/**
 * 
 */
public class NetworkWatcher extends Watcher {

	/**
	 * Default constructor
	 */
	public NetworkWatcher() {
	}

	//@Override
	public void run() {
		// TODO Auto-generated method stub
		//dd
	}
	
	
	/*
	 * méthodes qui permet d'appeler l'écoute sur Tcpdump
	 * 
	 */
	public static void runTCPDUmp() {
		int increment = 1;
		String fileName ="sorti_numero_"+increment+".txt";
		String tcpdumpCmdResponse = "";
		ProcessBuilder constructionProcess = null;
		
		constructionProcess = new ProcessBuilder("tcpdump","-c 100","udp","dst port 53");
		
 
		constructionProcess.redirectErrorStream(true);
 
		try {
			while(true)
			{
			Process process = constructionProcess.start();
				InputStream recupFluxDonnee = process.getInputStream();
				tcpdumpCmdResponse = getStringFromStream(recupFluxDonnee);
				BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
				out.write(tcpdumpCmdResponse);
				recupFluxDonnee.close();
				out.close();
				increment++;
				fileName ="sorti_numero_"+increment+".txt";
			}
 
		} catch (Exception e) {
			System.out.println("Error Executing tcpdump command" + e);
		}
		
	}
	/*
	 * méthodes étant utiliser dans runTCPDUmp pour convertir le flux d'informations
	 * reçu en une chaine de caractère pouvant être utilisé dans le programme ou bien
	 * redirigé vers un fichier.
	 */
	private static String getStringFromStream(InputStream recupFluxDonnee) throws IOException {
		if (recupFluxDonnee != null) {
			Writer streamIntoString = new StringWriter();
 
			char[] buffer = new char[2048];
			try {
				Reader lectureBuffer = new BufferedReader(new InputStreamReader(recupFluxDonnee, "UTF-8"));
				int count;
				while ((count = lectureBuffer.read(buffer)) != -1) {
					streamIntoString.write(buffer, 0, count);
				}
			} finally {
				recupFluxDonnee.close();
			}
			return streamIntoString.toString();
		} else {
			return "";
		}
	}
	
	public static void main(String args[])throws IOException{
		runTCPDUmp();
		System.out.println("bonjour");
		
	}

}