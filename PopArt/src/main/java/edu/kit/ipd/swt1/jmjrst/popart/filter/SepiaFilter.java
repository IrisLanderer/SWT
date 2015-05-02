package edu.kit.ipd.swt1.jmjrst.popart.filter;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class SepiaFilter implements ImageFilter {

	private int sepiaDepth;
	private int sepiaIntensity;

	public SepiaFilter() {
		this(20, 10);
	}
	
	public SepiaFilter(int depth, int intensity) {
		sepiaDepth = depth;
		sepiaIntensity = intensity;
	}

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		// TODO Auto-generated method stub
		return null;
	}
}
