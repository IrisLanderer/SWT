package edu.kit.ipd.swt1.jmjrst.popart.filter;

import java.awt.image.BufferedImage;

/**
 * ein Interface für die Filter
 * 
 * @author Iris
 *
 */
public interface ImageFilter {

	/**
	 * Apply the image filter to the given image. Does not alter the given image
	 * but returns a new, filtered one.
	 * 
	 * @param image
	 *            the image to be filtered
	 * @return a new image with the filter applied
	 */

	/**
	 * Methode, die den jeweiligen Filter auf dem Bild anwendet
	 * 
	 * @param image
	 *            Bild
	 * @return Bild, das mit Filter verändert wurde
	 */
	BufferedImage applyFilter(BufferedImage image);

}
