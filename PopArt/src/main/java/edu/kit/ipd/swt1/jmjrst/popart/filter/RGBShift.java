package edu.kit.ipd.swt1.jmjrst.popart.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * KLasse für den Farbtausch
 * 
 * @author Iris
 *
 */
public class RGBShift implements ImageFilter {

	/**
	 * Color channels in RGB mode...
	 * 
	 * @author Iris Landerer
	 * @version 1.0
	 */
	public enum Channel {
		RED, GREEN, BLUE
	}

	private Channel red;
	private Channel green;
	private Channel blue;

	/**
	 * Doesn't do any shifting... (red->red, green->green, blue->blue)
	 */
	public RGBShift() {
		this(Channel.RED, Channel.GREEN, Channel.BLUE);
	}

	/**
	 * Example: RGBShift(blue, red, green) will produce blue->red, red->green,
	 * green->blue
	 * 
	 * @param redSource
	 *            Channel that should go into the red channel.
	 * @param greenSource
	 *            Channel that should go into the green channel.
	 * @param blueSource
	 *            Channel that should go into the blue channel.
	 */
	public RGBShift(Channel redSource, Channel greenSource, Channel blueSource) {
		setChannelShift(redSource, greenSource, blueSource);
	}

	/**
	 * * @param redSource Channel that should go into the red channel.
	 * 
	 * @param greenSource
	 *            Channel that should go into the green channel.
	 * @param blueSource
	 *            Channel that should go into the blue channel.
	 */
	public void setChannelShift(Channel redSource, Channel greenSource,
			Channel blueSource) {
		red = redSource;
		green = greenSource;
		blue = blueSource;
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

				int redValue = red;
				int greenValue = green;
				int blueValue = blue;

				// set new red channel
				switch (this.red) {
				case BLUE:
					redValue = blue;
					break;
				case GREEN:
					redValue = green;
					break;
				case RED:
				default:
					break;
				}

				// set new green channel
				switch (this.green) {
				case RED:
					greenValue = red;
					break;
				case BLUE:
					greenValue = blue;
					break;
				case GREEN:
				default:
					break;
				}

				// set new blue channel
				switch (this.blue) {
				case RED:
					blueValue = red;
					break;
				case GREEN:
					blueValue = green;
					break;
				case BLUE:
				default:
					break;
				}

				Color newColor = new Color(redValue, greenValue, blueValue,
						alpha);
				image.setRGB(i, j, newColor.getRGB());
			}

		}

		return image;
	}
}
