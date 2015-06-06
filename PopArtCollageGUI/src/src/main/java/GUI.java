package src.main.java;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class GUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Pop-Art-Collage");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Components component = new Components();
		Container container = frame.getContentPane();
		container.add(new CollagePanel(), BorderLayout.WEST);
		component.addComponents(container);
		frame.setVisible(true);
	}
}
