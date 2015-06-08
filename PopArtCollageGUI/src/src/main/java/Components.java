package src.main.java;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import edu.kit.ipd.swt1.jmjrst.popart.SimplePopArtCollage;

public class Components {

	SimplePopArtCollage popart;

	private BufferedImage currentImage;

	private BufferedImage currentCollage;

	public Components(SimplePopArtCollage popart) {
		this.popart = popart;
	}

	public void addComponents(Container pane) {

		pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		JButton load = new JButton("Datei laden");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		// c.insets = new Insets(30, 30, 30, 30);
		pane.add(load, c);

		c = new GridBagConstraints();
		JButton save = new JButton("Datei speichern");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 2;
		// c.insets = new Insets(30, 30, 30, 30);
		pane.add(save, c);

		// c = new GridBagConstraints();
		JButton preview = new JButton("Vorschau");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		// c.insets = new Insets(30, 30, 30, 30);
		// c.gridwidth = 2;
		pane.add(preview, c);

		JLabel collage = new JLabel("Collage:");
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		pane.add(collage, c);

		final JPanel collagePanel = new CollagePanel();
		final JLabel collageLabel = new JLabel();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		// c.gridwidth = 2;
		// c.gridheight = 2;
		collagePanel.add(collageLabel);
		pane.add(collagePanel, c);
		File file = new File("src/main/resources/Yoda.jpg");
		System.out.println(file.exists());
		readCollage(collageLabel, null, file);

		final JTextField field = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		pane.add(field, c);

		load.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				final JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"jpg", "png");
				chooser.setFileFilter(filter);
				int value = chooser.showOpenDialog(null);
				if (value == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					readCollage(collageLabel, field, file);
				}
			}
		});
		preview.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentCollage != null) {
					BufferedImage collage = testOptionValue(currentImage,
							field.getText());
					BufferedImage resizedImage = resizeImage(collage);
					collageLabel.setIcon(new ImageIcon(resizedImage));
					currentCollage = resizedImage;
				}
			}
		});
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				final JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"jpg", "png");
				chooser.setFileFilter(filter);
				int value = chooser.showSaveDialog(null);
				if (value == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					String[] fileNameParts = file.getName().split("\\.");
					try {
						ImageIO.write(currentCollage,
								fileNameParts[fileNameParts.length - 1], file);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

	private void readCollage(final JLabel collageLabel, final JTextField field,
			File file) {
		try {
			currentImage = ImageIO.read(file);
			BufferedImage collage = testOptionValue(currentImage,
					field != null ? field.getText() : "");
			BufferedImage resizedImage = resizeImage(collage);
			collageLabel.setIcon(new ImageIcon(resizedImage));
			currentCollage = resizedImage;
		} catch (IOException e1) {
			System.out
					.println("Bei dieser Datei handelt es sich nicht um ein Bild!");
			e1.printStackTrace();
		}
	}

	private BufferedImage testOptionValue(BufferedImage image,
			String optionValue) {
		BufferedImage popArtCollage;
		if (optionValue.equals("")) {
			popArtCollage = popart.getCollage(image, "ogsw12345");
		} else if (optionValue.matches("[ogsw12345]")) {
			popArtCollage = popart.getCollage(image, optionValue);

		} else {
			throw new IllegalArgumentException("Ungueltiges Muster!");
		}

		return popArtCollage;

	}

	private static BufferedImage resizeImage(BufferedImage originalImage) {
		BufferedImage resizedImage = new BufferedImage(600, 600,
				originalImage.getType());
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, 600, 600, null);
		g.dispose();

		return resizedImage;
	}

}
