package edu.kit.ipd.swt1.jmjrst.popart.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Klasse für einen Graustufenfilter
 * 
 * @author Iris
 *
 */
public class GrayScaleFilter implements ImageFilter {

	public GrayScaleFilter() {

	}

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				int pixel = image.getRGB(i, j);
				int alpha = (pixel >> 24) & 0xff;
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				if (alpha < 0) {
					alpha = 0;
				}
				if (alpha > 255) {
					alpha = 255;
				}
				int grey = (red + blue + green) / 3;
				if (grey < 0) {
					grey = 0;
				}
				if (grey > 255) {
					grey = 255;
				}
				Color newColor = new Color(grey, grey, grey);
				image.setRGB(i, j, newColor.getRGB());
			}
		}
		return image;
	}

}