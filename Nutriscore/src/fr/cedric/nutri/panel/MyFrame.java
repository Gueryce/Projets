package fr.cedric.nutri.panel;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyFrame extends JFrame implements ChangeListener {

	
	JSlider jSlider;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public MyFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public MyFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		JPanel jPanel = new JPanel();
		this.add(jPanel);
		
		jSlider = new JSlider(0, 3, 0);
		Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
		position.put(0, new JLabel("A"));
		position.put(1, new JLabel("B"));
		position.put(2, new JLabel("C"));
		position.put(3, new JLabel("D"));
		jSlider.setPaintLabels(true);
		jSlider.setLabelTable(position);
		jSlider.addChangeListener(this);
		jPanel.add(jSlider);
		log("Chargement fini");
		
	}

	public MyFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source instanceof JSlider) {
			JSlider slider = (JSlider)source;
			//slider.setValue(Integer.valueOf(requestRandom()));
		}
	}

	public JSlider getjSlider() {
		return jSlider;
	}

	public void setjSlider(JSlider jSlider) {
		this.jSlider = jSlider;
	}
	
	public static void log(String mess) {
		Logger logger = System.getLogger("logger nutriscore");
		logger.log(Level.ALL, mess);
		System.out.println(mess);
	}
	

}
