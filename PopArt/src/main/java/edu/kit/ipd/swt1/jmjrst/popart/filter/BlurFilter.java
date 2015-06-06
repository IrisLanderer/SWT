package edu.kit.ipd.swt1.jmjrst.popart.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * KLasse für einen Weichzeichner in Form eines Boxfilters
 * 
 * @author Iris
 *
 */
public class BlurFilter implements ImageFilter {
	/**
	 * Standardkonstruktor
	 * 
	 */
	public BlurFilter() {

	}

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 1; i < width - 1; i++) {
			for (int j = 1; j < height - 1; j++) {
				int z = getRgb(16, image.getRGB(i - 1, j - 1),
						image.getRGB(i - 1, j + 1), image.getRGB(i + 1, j - 1),
						image.getRGB(i + 1, j + 1));
				z += getRgb(8, image.getRGB(i - 1, j), image.getRGB(i, j - 1),
						image.getRGB(i, j + 1), image.getRGB(i + 1, j));
				z += getRgb(4, image.getRGB(i, j));
				image.setRGB(i, j, z);
			}
		}
		return image;
	}

	private int getRgb(int factor, int... pixels) {
		int sumRed = 0;
		int sumGreen = 0;
		int sumBlue = 0;
		for (int pixel : pixels) {
			sumRed += (pixel >> 16) & 0xff;
			sumGreen += (pixel >> 8) & 0xff;
			sumBlue += (pixel) & 0xff;
		}
		Color newColor = new Color(sumRed / 16, sumGreen / 16, sumBlue / 16);
		return newColor.getRGB();
	}
}