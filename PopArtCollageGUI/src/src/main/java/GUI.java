package src.main.java;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import edu.kit.ipd.swt1.jmjrst.popart.SimplePopArtCollage;

public class GUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Pop-Art-Collage");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SimplePopArtCollage popart = new SimplePopArtCollage();
		Components component = new Components(popart);
		Container container = frame.getContentPane();
		container.add(new CollagePanel(), BorderLayout.SOUTH);
		component.addComponents(container);
		frame.setVisible(true);
	}
}
