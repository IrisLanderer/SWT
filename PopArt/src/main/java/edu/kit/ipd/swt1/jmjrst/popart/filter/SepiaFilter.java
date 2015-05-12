package edu.kit.ipd.swt1.jmjrst.popart.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Klasse für einen Sepiafilter
 * 
 * @author Iris
 *
 */
public class SepiaFilter implements ImageFilter {

	private int sepiaDepth;
	private int sepiaIntensity;

	/**
	 * Konstruktor, wenn keine Tiefe und Intensität explizit angegeben sind,
	 * wird Tiefe auf 20 und Intensität auf 10 gesetzt
	 */
	public SepiaFilter() {
		this(20, 10);
	}

	/**
	 * Konstruktor, wenn Tiefe und Intensität explizit angegeben sind
	 * 
	 * @param depth
	 *            Tiefe des Bildes
	 * @param intensity
	 *            Intensität des Bildes
	 */
	public SepiaFilter(int depth, int intensity) {
		sepiaDepth = depth;
		sepiaIntensity = intensity;
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

				int grey = (red + green + blue) / 3;
				red = grey;
				green = grey + 2 * sepiaDepth;
				blue = grey + sepiaDepth - sepiaIntensity;
				if (red < 0) {
					red = 0;
				}
				if (red > 255) {
					red = 255;
				}
				if (green < 0) {
					green = 0;
				}
				if (green > 255) {
					green = 255;
				}
				if (blue < 0) {
					blue = 0;
				}
				if (blue > 255) {
					blue = 255;
				}
				if (alpha < 0) {
					alpha = 0;
				}
				if (alpha > 255) {
					alpha = 255;
				}

				Color newColor = new Color(red, green, blue, alpha);
				image.setRGB(i, j, newColor.getRGB());
			}
		}
		return image;
	}
}