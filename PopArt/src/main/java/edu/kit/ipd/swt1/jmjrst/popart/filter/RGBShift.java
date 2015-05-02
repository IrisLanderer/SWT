package edu.kit.ipd.swt1.jmjrst.popart.filter;

import java.awt.image.BufferedImage;

public class RGBShift implements ImageFilter {

	/**
	 * Color channels in RGB mode...
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
		// TODO Auto-generated method stub
		return null;
	}

		

}
