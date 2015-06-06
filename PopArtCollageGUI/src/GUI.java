import javax.swing.JFrame;

public class GUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Pop-Art-Collage");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Components component = new Components();
		component.addComponents(frame.getContentPane());
		frame.setVisible(true);
	}
}
