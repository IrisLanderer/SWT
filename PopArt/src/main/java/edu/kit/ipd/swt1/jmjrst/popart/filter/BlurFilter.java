package edu.kit.ipd.swt1.jmjrst.popart.filter;

import java.awt.image.BufferedImage;

/**
 * KLasse für einen Weichzeichner in Form eines Boxfilters
 * 
 * @author Iris
 *
 */
public class BlurFilter implements ImageFilter {

	public BlurFilter() {

	}

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		int[][] pixels = new int[width][height];
		for (int i = 1; i < width - 1; i++) {
			for (int j = 1; j < height - 1; j++) {
				pixels[i][j] = (image.getRGB(i - 1, j - 1)
						+ image.getRGB(i - 1, j + 1)
						+ image.getRGB(i + 1, j - 1) + image.getRGB(i + 1,
						j + 1))
						/ 16
						+ (image.getRGB(i - 1, j) + image.getRGB(i, j - 1)
								+ image.getRGB(i, j + 1) + image.getRGB(i + 1,
								j)) / 8 + image.getRGB(i, j) / 4;
				image.setRGB(i, j, pixels[i][j]);
			}
		}
		return image;
	}

}
