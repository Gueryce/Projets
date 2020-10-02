package fr.cedric.nutri.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JSlider;

import fr.cedric.nutri.panel.MyFrame;

public class Worker implements Runnable {

	JSlider slider;
	
	public Worker() {
		// TODO Auto-generated constructor stub
	}

	public Worker(JSlider slider) {
		this.slider = slider;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(10000);
				slider.setValue(Integer.valueOf(requestRandom()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String requestRandom() {
		String url = "https://www.random.org/integers/?num=1&min=0&max=3&col=1&base=10&format=plain&rnd=new";
		String charset = "UTF-8"; 
		URLConnection connection;
		InputStream response = null;
		byte[] readAllBytes = new byte[100];
		String val = null;
		try {
			connection = new URL(url).openConnection();
			connection.setRequestProperty("Accept-Charset", charset);
			response = connection.getInputStream();
			
			if(response.available() > 0) {
				readAllBytes = response.readAllBytes();
				val = new String(readAllBytes).trim();
				MyFrame.log("Valeur Nutriscore : " + val);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}

}
