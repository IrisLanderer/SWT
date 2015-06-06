import javax.swing.JOptionPane;

import org.jis.Main;
import org.jis.plugins.JmjrstPlugin;

public class HalloJmjrstSwtPlugin extends JmjrstPlugin {

	String name;

	@Override
	public String getMenuText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void init(Main main) {
		System.out.println("Bitte konfiguriere mich!");

	}

	@Override
	public void run() {
		System.err.println("Ich wurde noch nicht implementiert!");

	}

	@Override
	public boolean isConfigurable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void configure() {
		JOptionPane.showMessageDialog(null, getName());
	}

}
