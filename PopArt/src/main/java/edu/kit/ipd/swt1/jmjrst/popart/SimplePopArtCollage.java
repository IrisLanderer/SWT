package edu.kit.ipd.swt1.jmjrst.popart;

import java.awt.image.BufferedImage;

import edu.kit.ipd.swt1.jmjrst.popart.filter.BlurFilter;
import edu.kit.ipd.swt1.jmjrst.popart.filter.GrayScaleFilter;
import edu.kit.ipd.swt1.jmjrst.popart.filter.RGBShift;
import edu.kit.ipd.swt1.jmjrst.popart.filter.RGBShift.Channel;
import edu.kit.ipd.swt1.jmjrst.popart.filter.SepiaFilter;

/**
 * KLasse zum Erstellen der Collage
 * 
 * @author Iris
 *
 */
public class SimplePopArtCollage {

	/**
	 * Methode erstellt Collage
	 * 
	 * @param image
	 *            Bild
	 * @param optionValue
	 *            Muster
	 * @return Collage
	 */
	public BufferedImage getCollage(BufferedImage image, String optionValue) {
		int width = image.getWidth();
		int height = image.getHeight();
		int type = image.getType();
		int deltaX = 0;
		int deltyY = 0;
		BufferedImage collage = null;
		if (optionValue.length() == 4) {
			collage = new BufferedImage(width * 2, height * 2, type);
		} else if (optionValue.length() == 9) {
			collage = new BufferedImage(width * 3, height * 3, type);
		}
		for (char c : optionValue.toCharArray()) {
			BufferedImage imageToBeAdded = image;
			Channel red = Channel.RED;
			Channel green = Channel.GREEN;
			Channel blue = Channel.BLUE;
			switch (c) {
			case 'o':
				// Originalbild
				break;
			case 's':
				imageToBeAdded = new SepiaFilter().applyFilter(image);
				break;
			case 'g':
				imageToBeAdded = new GrayScaleFilter().applyFilter(image);
				break;
			case 'w':
				imageToBeAdded = new BlurFilter().applyFilter(image);
				break;
			case '1':
				imageToBeAdded = new RGBShift(green, blue, red)
						.applyFilter(image);
				break;
			case '2':
				imageToBeAdded = new RGBShift(blue, red, green)
						.applyFilter(image);
				break;
			case '3':
				imageToBeAdded = new RGBShift(red, blue, green)
						.applyFilter(image);
				break;
			case '4':
				imageToBeAdded = new RGBShift(green, red, blue)
						.applyFilter(image);
				break;
			case '5':
				imageToBeAdded = new RGBShift(blue, green, red)
						.applyFilter(image);
				break;
			default:
				break;
			}

			// wenn noch nicht die Weite erreicht wurde, zeichne das Bild in
			// dieselbe Spalte
			// ansonsten wechsel in die nächste Spalte und wieder beginne
			// ganz links
			if (deltaX < collage.getWidth()) {
				collage.createGraphics().drawImage(imageToBeAdded, deltaX,
						deltyY, null);
				deltaX += width;
			} else {
				deltaX = 0;
				deltyY += height;
				collage.createGraphics().drawImage(imageToBeAdded, deltaX,
						deltyY, null);
				deltaX += width;
			}
		}
		return collage;

	}
}
