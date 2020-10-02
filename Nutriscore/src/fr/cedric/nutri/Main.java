/**
 * 
 */
package fr.cedric.nutri;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

import fr.cedric.nutri.controller.Worker;
import fr.cedric.nutri.panel.MyFrame;

/**
 * @author Admin
 *
 */
public class Main {

	
	MyFrame myFrame;
	
	/**
	 * 
	 */
	public Main() {
		// On invoque depuis l'EDT
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				myFrame = new MyFrame("Nutriscore");
				myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				myFrame.pack();
				myFrame.setVisible(true);
			}
		});

		// Lancement de la mise à jour des scores
		try {
			Thread.sleep(2000);
			JSlider getjSlider = myFrame.getjSlider();
			Worker worker = new Worker(getjSlider);
			worker.run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();

	}

}
