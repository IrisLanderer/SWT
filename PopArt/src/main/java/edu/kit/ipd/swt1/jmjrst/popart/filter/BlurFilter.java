package edu.kit.ipd.swt1.jmjrst.popart.filter;

import java.awt.image.BufferedImage;

/**
 * KLasse für einen Weichzeichner in Form eines Boxfilters
 * 
 * @author Iris
 *
 */
public class BlurFilter implements ImageFilter {

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		int[][] pixels = new int[width][height];
		for (int i = 1; i < width - 1; i++) {
			for (int j = 1; j < height - 1; j++) {
				pixels[i][j] = 1
						/ 16
						* (image.getRGB(i - 1, j - 1)
								+ image.getRGB(i - 1, j + 1)
								+ image.getRGB(i + 1, j - 1) + image.getRGB(
								i + 1, j + 1))
						+ 1
						/ 8
						* (image.getRGB(i - 1, j) + image.getRGB(i, j - 1)
								+ image.getRGB(i, j + 1) + image.getRGB(i + 1,
								j)) + 1 / 4 * image.getRGB(i, j);
				image.setRGB(i, j, pixels[i][j]);
			}
		}
		return image;
	}

}
